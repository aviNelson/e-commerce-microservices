package com.example.orderservice.service;

import com.example.orderservice.event.KafkaProducer;
import com.example.orderservice.event.OrderPlacedEvent;
import com.example.orderservice.feignclient.FeignInventoryService;
import com.example.orderservice.dto.InventoryDto;
import com.example.orderservice.dto.RequestOrder;
import com.example.orderservice.dto.ResponseOrder;
import com.example.orderservice.entity.OrderItem;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final FeignInventoryService feignInventoryService;
    private final OrderMapper orderMapper;
    private final CheckProductsInStock checkProductsInStock;
    private final ReduceQuantity reduceQuantity;
    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;

    @Override
    public ResponseOrder placeOrder(RequestOrder requestOrder) {
        return Optional.of(requestOrder)
                .map(OrderMapper.INSTANCE::dtoToEntity)
                .map(order -> {
                    order.setOrderNumber(UUID.randomUUID().toString());
                    orderMapper.linkOrderItems(order);

                    List<String> skuCodes = order.getOrderItems().stream().map(OrderItem::getSkuCode).collect(Collectors.toList());
                    List<InventoryDto> inventoryResponsesList = feignInventoryService.getAll(skuCodes);

                    if (checkProductsInStock.allProductsInStock(inventoryResponsesList,order)){
                        List<InventoryDto> newInventoryDtos = reduceQuantity.reduce(inventoryResponsesList, order.getOrderItems());
                        feignInventoryService.update(newInventoryDtos);
                        kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
                        return order;
                    }
                    else throw new IllegalArgumentException("Not all products are in stock, please try again later");

                })
                .map(orderRepository::save)
                .map(OrderMapper.INSTANCE::entityToDto)
                .orElseThrow();
    }


}


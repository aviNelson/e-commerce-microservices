package com.example.orderservice.service;

import com.example.orderservice.exeption.NotAllMatchException;
import com.example.orderservice.feignclient.FeignInventoryService;
import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.RequestOrder;
import com.example.orderservice.dto.ResponseOrder;
import com.example.orderservice.entity.OrderItem;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @Override
    public ResponseOrder create(RequestOrder requestOrder) {
        return Optional.of(requestOrder)
                .map(OrderMapper.INSTANCE::dtoToEntity)
                .map(order -> {
                    order.setOrderNumber(UUID.randomUUID().toString());
                    orderMapper.linkOrderItems(order);

                    List<String> skuCodes = order.getOrderItems().stream().map(OrderItem::getSkuCode).collect(Collectors.toList());
                    List<InventoryResponse> inventoryResponsesList = feignInventoryService.getAll(skuCodes);

                    if (checkProductsInStock.allProductsInStock(inventoryResponsesList,skuCodes)){
                        return order;
                    }
                    else throw new IllegalArgumentException("Not all products are in stock, please try again later");

                })
                .map(orderRepository::save)
                .map(OrderMapper.INSTANCE::entityToDto)
                .orElseThrow();
    }


}


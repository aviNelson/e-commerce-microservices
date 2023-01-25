package com.example.orderservice.service;

import com.example.orderservice.dto.RequestOrder;
import com.example.orderservice.dto.ResponseOrder;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public ResponseOrder create(RequestOrder requestOrder) {
        return Optional.of(requestOrder)
                .map(OrderMapper.INSTANCE::dtoToEntity)
                .map(order -> {
                    order.setOrderNumber(UUID.randomUUID().toString());
                    orderMapper.linkOrderItems(order);
                    return order;
                })
                .map(orderRepository::save)
                .map(OrderMapper.INSTANCE::entityToDto)
                .orElseThrow();
    }


}


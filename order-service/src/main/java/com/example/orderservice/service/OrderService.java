package com.example.orderservice.service;

import com.example.orderservice.dto.RequestOrder;
import com.example.orderservice.dto.ResponseOrder;

public interface OrderService {

    public ResponseOrder create(RequestOrder requestOrder);
}

package com.example.orderservice.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.example.orderservice.entity.Order} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RequestOrder implements Serializable {

    @Builder.Default
    private List<OrderItemDto> orderItems = new ArrayList<>();
}
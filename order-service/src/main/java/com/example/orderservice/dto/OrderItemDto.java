package com.example.orderservice.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.example.orderservice.entity.OrderItem} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderItemDto implements Serializable {
    private Integer id;
    private String skuCode;
    private Integer quantity;
    private BigDecimal price;
}
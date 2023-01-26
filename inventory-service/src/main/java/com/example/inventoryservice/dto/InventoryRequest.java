package com.example.inventoryservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.inventoryservice.entity.Inventory} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryRequest implements Serializable {
    private String skuCode;
    private Integer quantity;
}
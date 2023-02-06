package com.example.orderservice.service;

import com.example.orderservice.dto.InventoryDto;
import com.example.orderservice.entity.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ReduceQuantity {

    public List<InventoryDto> reduce(List<InventoryDto> inventoryDtos, List<OrderItem> orderItems) {
        List<InventoryDto> newInventory = new ArrayList<>();
        for (InventoryDto inventoryDto : inventoryDtos) {
            for (OrderItem orderItem : orderItems) {
                if (inventoryDto.getSkuCode().equals(orderItem.getSkuCode())) {
                    inventoryDto.setQuantity(inventoryDto.getQuantity() - orderItem.getQuantity());
                    newInventory.add(inventoryDto);
                }
            }
        }
        return newInventory;
    }
}

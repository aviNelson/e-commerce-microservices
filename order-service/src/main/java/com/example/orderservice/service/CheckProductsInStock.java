package com.example.orderservice.service;

import com.example.orderservice.dto.InventoryDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CheckProductsInStock {

    public boolean allProductsInStock(List<InventoryDto> inventoryResponseList, Order order) {
        List<String> skuCodes = order.getOrderItems().stream().map(OrderItem::getSkuCode).collect(Collectors.toList());
        List<String> list = inventoryResponseList.stream().map(InventoryDto::getSkuCode).collect(Collectors.toList());
        boolean isAllMatch = inventoryResponseList.stream().allMatch(inventoryDto -> inventoryDto.getQuantity() > 0);
        boolean sufficientQuantity = isSufficientQuantity(inventoryResponseList, order.getOrderItems());

        return list.containsAll(skuCodes) && isAllMatch && sufficientQuantity;
    }

    public boolean isSufficientQuantity(List<InventoryDto> inventoryDtoList, List<OrderItem> orderItems) {

        for (InventoryDto inventoryDto : inventoryDtoList) {
            for (OrderItem orderItem : orderItems) {
                if (!(inventoryDto.getQuantity() >= orderItem.getQuantity())) {
                    return false;
                }
            }
        }
        return true;
    }


}

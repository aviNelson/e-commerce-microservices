package com.example.orderservice.service;

import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.feignclient.FeignInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class CheckProductsInStock {

    private final FeignInventoryService feignInventoryService;

    public boolean allProductsInStock(List<InventoryResponse> inventoryResponses, List<String> ckuCodes){
        List<String> list = inventoryResponses.stream().map(InventoryResponse::getSkuCode).collect(Collectors.toList());
        boolean isAllMatch = inventoryResponses.stream().allMatch(inventoryResponse -> inventoryResponse.getQuantity() > 0);
        return list.containsAll(ckuCodes) && isAllMatch;
    }






}

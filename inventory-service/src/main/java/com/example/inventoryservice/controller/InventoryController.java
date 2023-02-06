package com.example.inventoryservice.controller;


import com.example.inventoryservice.dto.InventoryRequest;
import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> getAll(@RequestParam List<String> skuCodes) {
        return inventoryService.getAll(skuCodes);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryResponse create(@RequestBody InventoryRequest inventoryRequest){
        return inventoryService.create(inventoryRequest);
    }

    @PostMapping("/update")
    public List<InventoryResponse> updateQuantity(@RequestBody List<InventoryRequest> list){
        return inventoryService.updateQuantitys(list);
    }
}

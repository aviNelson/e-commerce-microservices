package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryRequest;
import com.example.inventoryservice.dto.InventoryResponse;

public interface InventoryService {

    public InventoryResponse create(InventoryRequest inventoryRequest);

    public boolean isInStock(String skuCode);
}

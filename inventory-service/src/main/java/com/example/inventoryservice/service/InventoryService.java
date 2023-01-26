package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryRequest;
import com.example.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {

    public InventoryResponse create(InventoryRequest inventoryRequest);

    public List<InventoryResponse> getAll(List<String> skuCodes);
}

package com.example.orderservice.feignclient;

import com.example.orderservice.dto.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("inventory-service")
public interface FeignInventoryService {

    @GetMapping("/api/v1/inventory")
    public List<InventoryDto> getAll(@RequestParam List<String> skuCodes);

    @PostMapping("/api/v1/inventory/update")
    public void update(List<InventoryDto> inventoryDtos);
}

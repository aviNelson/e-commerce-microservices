package com.example.orderservice.feignclient;

import com.example.orderservice.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("inventory-service")
public interface FeignInventoryService {

    @GetMapping("/api/v1/inventory")
    public List<InventoryResponse> getAll(@RequestParam List<String> skuCodes);
}

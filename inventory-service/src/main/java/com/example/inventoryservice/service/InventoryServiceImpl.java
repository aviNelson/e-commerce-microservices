package com.example.inventoryservice.service;


import com.example.inventoryservice.dto.InventoryRequest;
import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.mapper.InventoryMapper;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryResponse create(InventoryRequest inventoryRequest) {
        return Optional.of(inventoryRequest)
                .map(InventoryMapper.INSTANCE::dtoToEntity)
                .map(inventoryRepository::save)
                .map(InventoryMapper.INSTANCE::entityToDto)
                .orElseThrow();
    }

    @Override
    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}

package com.example.inventoryservice.mapper;

import com.example.inventoryservice.dto.InventoryRequest;
import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.entity.Inventory;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InventoryMapper {

    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);
    Inventory dtoToEntity(InventoryRequest inventoryRequest);

    InventoryResponse entityToDto(Inventory inventory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory update(InventoryRequest inventoryRequest, @MappingTarget Inventory inventory);
}

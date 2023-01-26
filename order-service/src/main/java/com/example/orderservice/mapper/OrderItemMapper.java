//package com.example.orderservice.mapper;
//
//import com.example.orderservice.dto.OrderItemDto;
//import com.example.orderservice.entity.OrderItem;
//import org.mapstruct.*;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
//public interface OrderItemMapper {
//    OrderItem orderItemDtoToOrderItem(OrderItemDto orderItemDto);
//
//    OrderItemDto orderItemToOrderItemDto(OrderItem orderItem);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    OrderItem updateOrderItemFromOrderItemDto(OrderItemDto orderItemDto, @MappingTarget OrderItem orderItem);
//}

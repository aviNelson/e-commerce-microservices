package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper.INSTANCE::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        return Optional.of(productRequest)
                .map(ProductMapper.INSTANCE::dtoToEntity)
                .map(productRepository::save)
                .map(ProductMapper.INSTANCE::entityToDto)
                .orElseThrow();
    }
}

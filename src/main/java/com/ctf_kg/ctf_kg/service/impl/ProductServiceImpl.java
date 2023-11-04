package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.product.ProductResponse;
import com.ctf_kg.ctf_kg.mapper.product.ProductMapper;
import com.ctf_kg.ctf_kg.repositories.ProductRepository;
import com.ctf_kg.ctf_kg.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    @Override
    public List<ProductResponse> getAll() {
        return productMapper.toDtoS(productRepository.findAll());
    }
}

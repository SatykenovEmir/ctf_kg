package com.ctf_kg.ctf_kg.service;

import com.ctf_kg.ctf_kg.dto.product.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAll();

    List<ProductResponse> search(String search);

    int setFlag(String token, Long productId);

    List<Object[]> getFive();
}

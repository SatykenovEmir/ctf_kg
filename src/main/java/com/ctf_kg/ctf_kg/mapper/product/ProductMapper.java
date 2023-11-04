package com.ctf_kg.ctf_kg.mapper.product;

import com.ctf_kg.ctf_kg.dto.product.ProductResponse;
import com.ctf_kg.ctf_kg.entities.Product;

import java.util.List;

public interface ProductMapper {
    List<ProductResponse> toDtoS(List<Product> all);
}

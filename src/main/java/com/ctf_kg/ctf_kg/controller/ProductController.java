package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.dto.product.ProductResponse;
import com.ctf_kg.ctf_kg.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAll")
    public List<ProductResponse> getAllProducts(){
        return productService.getAll();
    }

    //private final ProducS
}

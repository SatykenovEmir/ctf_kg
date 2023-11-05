package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.dto.product.ProductResponse;
import com.ctf_kg.ctf_kg.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/search")
    public List<ProductResponse> searchProductResponse(@RequestParam(required = false) String search){
        return productService.search(search);
    }
    @PostMapping("/setFlag/{productId}")
    public int setFlag(@RequestHeader("Authorization") String token, @PathVariable Long productId){
        return productService.setFlag(token, productId);
    }
    @GetMapping("/getFiveMost")
    public List<Object[]> getFive(){
        return productService.getFive();
    }

    //private final ProducS
}

package com.ctf_kg.ctf_kg.mapper.product;


import com.ctf_kg.ctf_kg.dto.product.ProductResponse;
import com.ctf_kg.ctf_kg.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper{
    @Override
    public List<ProductResponse> toDtoS(List<Product> all) {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product: all){
            productResponses.add(toDto(product));
        }
        return productResponses;
    }

    private ProductResponse toDto(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setNumber(product.getNumber());
        productResponse.setNameOfProduct(product.getNameOfProduct());
        productResponse.setTypeOfProduct(product.getTypeofProduct());
        productResponse.setPlannedPrize(product.getPlannedPrize());
        productResponse.setOrganizationName(product.getOrganizationName());
        productResponse.setPublicationDate(product.getPublicationDate());
        productResponse.setSupplierProposalDeadLine(product.getSupplierProposalDeadLine());
        return productResponse;
    }
}

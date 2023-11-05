package com.ctf_kg.ctf_kg.dto.product;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String number;
    private String supplierProposalDeadLine;
    private String nameOfProduct;
    private String organizationName;
    private String plannedPrize;
    private String publicationDate;
    private String typeOfProduct;

    private int flag;//added just now



}

package com.ctf_kg.ctf_kg.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String organizationName;
    private String typeofProduct;
    private String nameOfProduct;
    private String buyMethod;
    private String plannedPrize;
    private String publicationDate;
    private String SupplierProposalDeadLine;

}

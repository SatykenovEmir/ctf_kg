package com.ctf_kg.ctf_kg.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    private String organizationName;
    private String typeofProduct;
    private String nameOfProduct;
    private String buyMethod;
    private String plannedPrize;
    private String publicationDate;
    private String SupplierProposalDeadLine;

    private int flag;//added just now
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CommentSmi> commentSmis = new ArrayList<>();
//

}

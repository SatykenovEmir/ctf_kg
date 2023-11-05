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
@AllArgsConstructor
@NoArgsConstructor
public class UserAllProductInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long productId;
    private Boolean isProduct;
    private Long contractsId;
    private Boolean isContracts;
    private Long budgetId;
    private Boolean idBudget;
    private Long notBudgetId;
    private Boolean isNotBudget;
}

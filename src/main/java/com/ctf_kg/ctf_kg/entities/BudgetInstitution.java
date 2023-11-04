package com.ctf_kg.ctf_kg.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String budgetId;
    private String accountNumber;
    private String accountName;
    private String expenditure;
    private String amount;
    private String reservedAmount;
    private String savedAmount;
    private String residualAmount;
    private String year;
}

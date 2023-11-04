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
public class Contracts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contractId;
    private String contractNumber;
    private String accountName;
    private String expendITure;
    private String amount;
    private String reservedAmount;
    private String savedAmount;
    private String residualAmount;
    private String year;

}

package com.ctf_kg.ctf_kg.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private String typeOfPlan;
    private String INN;
    private String nameOfCompany;
    private String year;
    private String amount;
    private String lastChange;
}

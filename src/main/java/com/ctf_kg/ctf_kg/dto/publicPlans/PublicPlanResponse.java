package com.ctf_kg.ctf_kg.dto.publicPlans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicPlanResponse {

    private Long id;
    private String number;
    private String typeOfPlan;
    private String INN;
    private String nameOfCompany;
    private String year;
    private String amount;
    private String lastChange;
}

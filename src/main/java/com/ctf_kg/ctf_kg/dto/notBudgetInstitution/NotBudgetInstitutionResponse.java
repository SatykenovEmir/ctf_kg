package com.ctf_kg.ctf_kg.dto.notBudgetInstitution;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotBudgetInstitutionResponse {

    private Long id;

    private String accountName;
    private String amount;
    private String year;
}

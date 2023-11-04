package com.ctf_kg.ctf_kg.dto.budgetInstitution;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BudgetInstitutionResponse {
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

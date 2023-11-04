package com.ctf_kg.ctf_kg.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractResponse {
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

package com.ctf_kg.ctf_kg.mapper.budgetInstitution;


import com.ctf_kg.ctf_kg.dto.budgetInstitution.BudgetInstitutionResponse;
import com.ctf_kg.ctf_kg.entities.BudgetInstitution;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BudgetInstitutionMapperImpl implements BudgetInstitutionMapper{
    @Override
    public List<BudgetInstitutionResponse> toDtoS(List<BudgetInstitution> all) {
        List<BudgetInstitutionResponse> budgetInstitutionResponses = new ArrayList<>();
        for (BudgetInstitution budgetInstitution: all){
            budgetInstitutionResponses.add(toDto(budgetInstitution));
        }
        return budgetInstitutionResponses;
    }

    private BudgetInstitutionResponse toDto(BudgetInstitution budgetInstitution) {
        BudgetInstitutionResponse budgetInstitutionResponse = new BudgetInstitutionResponse();
        budgetInstitutionResponse.setId(budgetInstitution.getId());
        budgetInstitutionResponse.setBudgetId(budgetInstitution.getBudgetId());
        budgetInstitutionResponse.setAmount(budgetInstitution.getAmount());
        budgetInstitutionResponse.setExpenditure(budgetInstitution.getExpenditure());
        budgetInstitutionResponse.setAccountName(budgetInstitution.getAccountName());
        budgetInstitutionResponse.setAccountNumber(budgetInstitution.getAccountNumber());
        budgetInstitutionResponse.setReservedAmount(budgetInstitution.getReservedAmount());
        budgetInstitutionResponse.setResidualAmount(budgetInstitution.getResidualAmount());
        budgetInstitutionResponse.setYear(budgetInstitution.getYear());
        budgetInstitutionResponse.setSavedAmount(budgetInstitution.getSavedAmount());
        return budgetInstitutionResponse;
    }
}

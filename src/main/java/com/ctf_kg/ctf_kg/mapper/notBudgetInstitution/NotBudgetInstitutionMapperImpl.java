package com.ctf_kg.ctf_kg.mapper.notBudgetInstitution;

import com.ctf_kg.ctf_kg.dto.notBudgetInstitution.NotBudgetInstitutionResponse;
import com.ctf_kg.ctf_kg.entities.NotBudgetInstitution;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotBudgetInstitutionMapperImpl implements NotBudgetInstitutionMapper{
    @Override
    public List<NotBudgetInstitutionResponse> toDtoS(List<NotBudgetInstitution> all) {
        List<NotBudgetInstitutionResponse> notBudgetInstitutionResponses = new ArrayList<>();
        for (NotBudgetInstitution notBudgetInstitution: all){
            notBudgetInstitutionResponses.add(toDto(notBudgetInstitution));
        }
        return notBudgetInstitutionResponses;
    }

    private NotBudgetInstitutionResponse toDto(NotBudgetInstitution notBudgetInstitution) {
        NotBudgetInstitutionResponse notBudgetInstitutionResponse = new NotBudgetInstitutionResponse();
        notBudgetInstitutionResponse.setId(notBudgetInstitution.getId());
        notBudgetInstitutionResponse.setAccountName(notBudgetInstitution.getAccountName());
        notBudgetInstitutionResponse.setAmount(notBudgetInstitution.getAmount());
        notBudgetInstitutionResponse.setYear(notBudgetInstitution.getYear());
        return notBudgetInstitutionResponse;
    }
}

package com.ctf_kg.ctf_kg.mapper.notBudgetInstitution;

import com.ctf_kg.ctf_kg.dto.notBudgetInstitution.NotBudgetInstitutionResponse;
import com.ctf_kg.ctf_kg.entities.NotBudgetInstitution;

import java.util.List;

public interface NotBudgetInstitutionMapper {
    List<NotBudgetInstitutionResponse> toDtoS(List<NotBudgetInstitution> all);
}

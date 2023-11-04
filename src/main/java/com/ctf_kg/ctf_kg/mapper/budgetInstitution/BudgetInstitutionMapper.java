package com.ctf_kg.ctf_kg.mapper.budgetInstitution;

import com.ctf_kg.ctf_kg.dto.budgetInstitution.BudgetInstitutionResponse;
import com.ctf_kg.ctf_kg.entities.BudgetInstitution;

import java.util.List;

public interface BudgetInstitutionMapper {
    List<BudgetInstitutionResponse> toDtoS(List<BudgetInstitution> all);
}

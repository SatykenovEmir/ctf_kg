package com.ctf_kg.ctf_kg.service;

import com.ctf_kg.ctf_kg.dto.budgetInstitution.BudgetInstitutionResponse;

import java.util.List;

public interface BudgetInstitutionService {
    List<BudgetInstitutionResponse> getAll();
}

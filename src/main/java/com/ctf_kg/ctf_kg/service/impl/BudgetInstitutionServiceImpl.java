package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.budgetInstitution.BudgetInstitutionResponse;
import com.ctf_kg.ctf_kg.mapper.budgetInstitution.BudgetInstitutionMapper;
import com.ctf_kg.ctf_kg.repositories.BudgetInstitutionRepository;
import com.ctf_kg.ctf_kg.service.BudgetInstitutionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BudgetInstitutionServiceImpl implements BudgetInstitutionService {
    private final BudgetInstitutionMapper budgetInstitutionMapper;
    private final BudgetInstitutionRepository budgetInstitutionRepository;
    @Override
    public List<BudgetInstitutionResponse> getAll() {
        return budgetInstitutionMapper.toDtoS(budgetInstitutionRepository.findAll());
    }
}

package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.notBudgetInstitution.NotBudgetInstitutionResponse;
import com.ctf_kg.ctf_kg.mapper.notBudgetInstitution.NotBudgetInstitutionMapper;
import com.ctf_kg.ctf_kg.repositories.NotBudgetInstitutionRepository;
import com.ctf_kg.ctf_kg.service.NotBudgetInstitutionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotBudgetInstitutionServiceImpl implements NotBudgetInstitutionService {
    private final NotBudgetInstitutionMapper notBudgetInstitutionMapper;
    private final NotBudgetInstitutionRepository notBudgetInstitutionRepository;
    @Override
    public List<NotBudgetInstitutionResponse> getAll() {
        return notBudgetInstitutionMapper.toDtoS(notBudgetInstitutionRepository.findAll());
    }
}

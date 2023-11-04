package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.dto.budgetInstitution.BudgetInstitutionResponse;
import com.ctf_kg.ctf_kg.dto.notBudgetInstitution.NotBudgetInstitutionResponse;
import com.ctf_kg.ctf_kg.service.BudgetInstitutionService;
import com.ctf_kg.ctf_kg.service.NotBudgetInstitutionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class PlanController {

    private final BudgetInstitutionService budgetInstitutionService;
    private final NotBudgetInstitutionService notBudgetInstitutionService;
    @GetMapping("/getAllBudgetInstition")
    public List<BudgetInstitutionResponse> getAll(){
        return budgetInstitutionService.getAll();
    }
    @GetMapping("/getAllNotBudgetInstition")
    public List<NotBudgetInstitutionResponse> getAllNotBudget(){
        return notBudgetInstitutionService.getAll();
    }
}

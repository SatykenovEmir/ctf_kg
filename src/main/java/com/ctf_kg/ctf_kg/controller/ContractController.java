package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.dto.contract.ContractResponse;
import com.ctf_kg.ctf_kg.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class ContractController {

    private final ContractService contractService;

    @GetMapping("/getAll")
    public List<ContractResponse> getAll(){
        return contractService.getAll();
    }


}

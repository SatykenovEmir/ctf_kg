package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.contract.ContractResponse;
import com.ctf_kg.ctf_kg.entities.Contracts;
import com.ctf_kg.ctf_kg.mapper.contract.ContractMapper;
import com.ctf_kg.ctf_kg.repositories.ContractRepository;
import com.ctf_kg.ctf_kg.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final ContractMapper contractMapper;
    private final ContractRepository contractRepository;
    @Override
    public List<ContractResponse> getAll() {
        return contractMapper.toDtoS(contractRepository.findAll());
    }
}

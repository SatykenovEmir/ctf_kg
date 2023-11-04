package com.ctf_kg.ctf_kg.service;

import com.ctf_kg.ctf_kg.dto.contract.ContractResponse;

import java.util.List;

public interface ContractService {
    List<ContractResponse> getAll();
}

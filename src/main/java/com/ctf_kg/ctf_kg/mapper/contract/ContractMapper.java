package com.ctf_kg.ctf_kg.mapper.contract;

import com.ctf_kg.ctf_kg.dto.contract.ContractResponse;
import com.ctf_kg.ctf_kg.entities.Contracts;

import java.util.List;

public interface ContractMapper {
    List<ContractResponse> toDtoS(List<Contracts> all);
}

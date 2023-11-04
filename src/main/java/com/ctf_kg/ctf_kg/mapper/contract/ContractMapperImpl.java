package com.ctf_kg.ctf_kg.mapper.contract;

import com.ctf_kg.ctf_kg.dto.contract.ContractResponse;
import com.ctf_kg.ctf_kg.entities.Contracts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContractMapperImpl implements ContractMapper {
    @Override
    public List<ContractResponse> toDtoS(List<Contracts> all) {
        List<ContractResponse> contractResponses = new ArrayList<>();
        for (Contracts contracts: all){
            contractResponses.add(toDto(contracts));
        }
        return contractResponses;
    }

    private ContractResponse toDto(Contracts contracts) {
        ContractResponse contractResponse = new ContractResponse();
        contractResponse.setId(contracts.getId());
        contractResponse.setContractId(contracts.getContractId());
        contractResponse.setContractNumber(contracts.getContractNumber());
        contractResponse.setAmount(contracts.getAmount());
        contractResponse.setYear(contracts.getYear());
        contractResponse.setAccountName(contracts.getAccountName());
        contractResponse.setReservedAmount(contracts.getReservedAmount());
        contractResponse.setSavedAmount(contracts.getSavedAmount());
        contractResponse.setResidualAmount(contracts.getResidualAmount());
        contractResponse.setExpendITure(contracts.getExpendITure());
        return contractResponse;

    }
}

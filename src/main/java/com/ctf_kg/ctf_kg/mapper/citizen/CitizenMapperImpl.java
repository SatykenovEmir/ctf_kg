package com.ctf_kg.ctf_kg.mapper.citizen;

import com.ctf_kg.ctf_kg.dto.citizen.CitizenResponse;
import com.ctf_kg.ctf_kg.entities.Citizen;
import com.ctf_kg.ctf_kg.mapper.citizen.CitizenMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CitizenMapperImpl implements CitizenMapper {
    @Override
    public List<CitizenResponse> toDtos(List<Citizen> all) {
        List<CitizenResponse> citizenResponses = new ArrayList<>();
        for (Citizen citizen: all){
            citizenResponses.add(toDto(citizen));
        }
        return citizenResponses;
    }

    private CitizenResponse toDto(Citizen citizen) {
        CitizenResponse citizenResponse = new CitizenResponse();
        citizenResponse.setFirstname(citizen.getFirstname());
        citizenResponse.setLastname(citizen.getLastname());
        citizenResponse.setEmail(citizen.getEmail());
        citizenResponse.setRole(citizen.getRole());
        return citizenResponse;
    }

}

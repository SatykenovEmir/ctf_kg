package com.ctf_kg.ctf_kg.mapper.citizen;

import com.ctf_kg.ctf_kg.dto.citizen.CitizenResponse;
import com.ctf_kg.ctf_kg.entities.Citizen;

import java.util.List;

public interface CitizenMapper {
    List<CitizenResponse> toDtos(List<Citizen> all);
}

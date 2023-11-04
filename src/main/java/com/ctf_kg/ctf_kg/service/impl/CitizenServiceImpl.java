package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.citizen.CitizenResponse;
import com.ctf_kg.ctf_kg.mapper.citizen.CitizenMapper;
import com.ctf_kg.ctf_kg.repositories.CitizenRepository;
import com.ctf_kg.ctf_kg.service.CitizenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CitizenServiceImpl implements CitizenService {

    private final CitizenMapper citizenMapper;
    private final CitizenRepository citizenRepository;
    @Override
    public List<CitizenResponse> getAll() {

        return citizenMapper.toDtos(citizenRepository.findAll());
    }
}

package com.ctf_kg.ctf_kg.mapper.smi;


import com.ctf_kg.ctf_kg.dto.file.FileMapper;
import com.ctf_kg.ctf_kg.dto.smi.SmiResponse;
import com.ctf_kg.ctf_kg.entities.User;
import com.ctf_kg.ctf_kg.repositories.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SmiMapperImpl implements SmiMapper{
    private final FileRepository fileRepository;
    private final FileMapper fileMapper;
    @Override
    public SmiResponse toDto(User save) {
        SmiResponse smiResponse = new SmiResponse();
        smiResponse.setFileResponse(fileMapper.toDto(save.getFileSMI()));
        smiResponse.setRole(save.getRole());
        smiResponse.setFirstname(save.getFirstname());
        smiResponse.setEmail(save.getEmail());
        smiResponse.setUserId(save.getId());
        smiResponse.setLastname(save.getLastname());
        return smiResponse;
    }
}

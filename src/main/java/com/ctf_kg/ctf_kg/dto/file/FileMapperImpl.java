package com.ctf_kg.ctf_kg.dto.file;

import com.ctf_kg.ctf_kg.entities.FileData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileMapperImpl implements FileMapper {
    @Override
    public FileResponse toDto(FileData fileData) {
        if (fileData==null){
            return null;
        }
        FileResponse response=new FileResponse();
        response.setPath(fileData.getPath());
        response.setId(fileData.getId());
        response.setName(fileData.getName());
        response.setType(fileData.getType());

        return response;
    }

    @Override
    public List<FileResponse> toDtos(List<FileData> files) {
        List<FileResponse> responses=new ArrayList<>();
        for (FileData file:files) {
            responses.add(toDto(file));
        }
        return responses;
    }
}

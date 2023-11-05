package com.ctf_kg.ctf_kg.dto.file;


import com.ctf_kg.ctf_kg.entities.FileData;

import java.util.List;

public interface FileMapper {
    FileResponse toDto(FileData fileData);

    List<FileResponse> toDtos(List<FileData> files);
}

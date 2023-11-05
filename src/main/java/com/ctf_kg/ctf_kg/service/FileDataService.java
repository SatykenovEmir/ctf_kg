package com.ctf_kg.ctf_kg.service;

import com.ctf_kg.ctf_kg.dto.file.FileResponse;
import com.ctf_kg.ctf_kg.entities.FileData;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FileDataService {
    FileData uploadFile(MultipartFile file, FileData pdf) ;

    FileData uploadFile(MultipartFile file) ;

    void downloadFile(Long id, HttpServletResponse http) ;

    void getFileById(Long id, HttpServletResponse httpServletResponse);


    FileResponse uploadResume(MultipartFile file, Long id) throws IOException;
}

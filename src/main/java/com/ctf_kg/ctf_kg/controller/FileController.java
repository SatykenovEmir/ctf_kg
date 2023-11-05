package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.service.FileDataService;
import com.ctf_kg.ctf_kg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class FileController {

    private final FileDataService fileDataService;
    private final UserService userService;


    @GetMapping("/resume/{id}")
    public void getFileById(@PathVariable Long id, HttpServletResponse httpServletResponse){
        fileDataService.getFileById(id, httpServletResponse);
    }

    @GetMapping("/download/file/{id}")
    public void downloadFile(@PathVariable Long id, HttpServletResponse http) throws IOException {
        fileDataService.downloadFile(id, http);
    }





    @PostMapping("/upload/{employerId}")
    public ResponseEntity<?> uploadResume1(@RequestPart MultipartFile file, @PathVariable Long employerId) throws IOException {

        return ResponseEntity.status(HttpStatus.OK)
                .body(fileDataService.uploadResume(file, employerId));
    }


}

package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.service.ParserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/parser")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ParserController {

   // private final ParserService parserService;

//    @GetMapping("/parse")
//    void someValues(@RequestParam(required = false) String url) throws IOException {
//        parserService.parsePages(url, 3);
//    }

}

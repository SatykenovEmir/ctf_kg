package com.ctf_kg.ctf_kg.controller;


import com.ctf_kg.ctf_kg.dto.organization.OrganizationResponse;
import com.ctf_kg.ctf_kg.entities.Organization;
import com.ctf_kg.ctf_kg.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class RangController {
    private final OrganizationService organizationService;
    @GetMapping("/rangs")
    public List<OrganizationResponse> getRangs(){
        return organizationService.getRangs();
    }

}

package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.dto.organization.OrganizationResponse;
import com.ctf_kg.ctf_kg.entities.Organization;
import com.ctf_kg.ctf_kg.entities.Product;
import com.ctf_kg.ctf_kg.mapper.organization.OrganizationMapper;
import com.ctf_kg.ctf_kg.repositories.OrganizationRepository;
import com.ctf_kg.ctf_kg.repositories.ProductRepository;
import com.ctf_kg.ctf_kg.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationMapper organizationMapper;
    private final OrganizationRepository organizationRepository;
    private final ProductRepository productRepository;
    public List<OrganizationResponse> getRangs() {
        // Retrieve the count of products per organization
        List<Object[]> counts = productRepository.countProductsByOrganization();

        // Map the results to OrganizationResponse
        return counts.stream().map(result -> {
            OrganizationResponse response = new OrganizationResponse();
            response.setOrganizationName((String) result[0]);
            response.setPoints(((Long) result[1]).intValue()); // Convert Long to int
            // If you had the organization IDs and they were needed, you would set them here
            // response.setOrganizationId(...);
            return response;
        }).collect(Collectors.toList());
    }
}

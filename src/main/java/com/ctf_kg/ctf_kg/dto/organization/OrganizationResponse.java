package com.ctf_kg.ctf_kg.dto.organization;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationResponse {
    private Long organizationId;
    private String organizationName;
    private int points;
}

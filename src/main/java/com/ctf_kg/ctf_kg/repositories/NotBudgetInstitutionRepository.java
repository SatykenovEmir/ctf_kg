package com.ctf_kg.ctf_kg.repositories;

import com.ctf_kg.ctf_kg.entities.NotBudgetInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotBudgetInstitutionRepository extends JpaRepository<NotBudgetInstitution, Long> {
}

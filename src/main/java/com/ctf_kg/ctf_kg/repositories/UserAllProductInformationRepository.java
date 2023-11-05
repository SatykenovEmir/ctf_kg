package com.ctf_kg.ctf_kg.repositories;

import com.ctf_kg.ctf_kg.entities.UserAllProductInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserAllProductInformationRepository extends JpaRepository<UserAllProductInformation, Long> {
    Optional<UserAllProductInformation> findByUserIdAndProductId(Long userId, Long productId);
}

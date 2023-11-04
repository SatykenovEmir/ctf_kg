package com.ctf_kg.ctf_kg.repositories;

import com.ctf_kg.ctf_kg.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}

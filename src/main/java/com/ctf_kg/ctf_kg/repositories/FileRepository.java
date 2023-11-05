package com.ctf_kg.ctf_kg.repositories;

import com.ctf_kg.ctf_kg.entities.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileData, Long> {

    FileData findByName(String name);
}

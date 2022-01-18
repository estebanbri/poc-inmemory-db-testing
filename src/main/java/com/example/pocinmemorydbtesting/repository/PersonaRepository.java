package com.example.pocinmemorydbtesting.repository;

import com.example.pocinmemorydbtesting.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}

package com.iddelgrupo.artefacto_ingresado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iddelgrupo.artefacto_ingresado.entidad.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    
}

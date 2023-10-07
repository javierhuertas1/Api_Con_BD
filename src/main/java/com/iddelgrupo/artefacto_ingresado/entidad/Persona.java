package com.iddelgrupo.artefacto_ingresado.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DNI;
    private Integer edad;
    private String nombre; 
    private String apellido;
    
}

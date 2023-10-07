package com.iddelgrupo.artefacto_ingresado.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iddelgrupo.artefacto_ingresado.entidad.Persona;
import com.iddelgrupo.artefacto_ingresado.repositorio.PersonaRepository;

@Service
public class PersonaSerivio {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> lsitarPersonas(){
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(Integer id) {
        return personaRepository.findById(id);
    }

    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public Persona actualizarPersona(Integer idEstudiante , Persona persona ){
        Optional<Persona> personaOptionalValidacion = personaRepository.findById(persona.getDNI());
        if(personaOptionalValidacion.isPresent()){
            Persona actualizar = personaOptionalValidacion.get();
            actualizar.setNombre(persona.getNombre());
            actualizar.setEdad(persona.getEdad());
            actualizar.setApellido(persona.getApellido());
            return personaRepository.save(actualizar);
        }
        return null;

    }

    
        public void eliminarPersona(Integer id){
            personaRepository.deleteById(id);
        }

        

}

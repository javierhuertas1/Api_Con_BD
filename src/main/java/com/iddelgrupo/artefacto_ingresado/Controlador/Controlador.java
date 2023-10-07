package com.iddelgrupo.artefacto_ingresado.Controlador;

import java.util.List;
import java.util.Optional;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iddelgrupo.artefacto_ingresado.entidad.Persona;
import com.iddelgrupo.artefacto_ingresado.servicio.PersonaSerivio;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class Controlador {
    @Autowired
    private PersonaSerivio personaServicio;

    @GetMapping("/Index")
    public String Incio() {
        return "Home";
    }

    @GetMapping("/ListarPesonas")
    public List<Persona> listaPersonas(){
        return personaServicio.lsitarPersonas();
    }
    @DeleteMapping("/EliminarPersona")
    public void crearPers(@RequestParam("id") Integer id) {
        personaServicio.eliminarPersona(id);
    }

    @PostMapping("/CrearPersona")
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaServicio.crearPersona(persona);
    }

    @PutMapping("/ActualizarPersona")
    public Persona putPersona(@RequestBody Persona PersonaDatosActualizar) {
        Optional<Persona> existePersona = personaServicio.obtenerPersonaPorId(PersonaDatosActualizar.getDNI());
        if (existePersona.isPresent()) {
            Persona personaExi = existePersona.get();
            personaExi.setApellido(PersonaDatosActualizar.getApellido());
            personaExi.setEdad(PersonaDatosActualizar.getEdad());
            personaExi.setNombre(PersonaDatosActualizar.getNombre());
            return personaServicio.actualizarPersona(PersonaDatosActualizar.getDNI(), PersonaDatosActualizar);
        } else {
            PersonaDatosActualizar.setApellido("No se actualizo");
            PersonaDatosActualizar.setEdad(0);
            PersonaDatosActualizar.setNombre("No se actualizo");
        }
        return PersonaDatosActualizar;
    }

}

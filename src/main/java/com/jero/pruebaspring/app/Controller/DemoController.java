package com.jero.pruebaspring.app.Controller;

import com.jero.pruebaspring.app.Exceptions.PersonaNotFoundException;
import com.jero.pruebaspring.app.Service.IPersonaService;
import com.jero.pruebaspring.app.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
@RestController
@RequestMapping("/v1")
public class DemoController {

    @Autowired
    private IPersonaService personaService;

    public DemoController() {
    }

    public DemoController(IPersonaService personaService) {
        this.personaService = personaService;
    }



    @GetMapping("/Persona")
    public List<Persona> obtenerTodasLasPersonas(){//Buscar todos los objetos en tu basa de datos
        List<Persona> personas = (List<Persona>) personaService.findPersonaAll();
        return (List<Persona>) personas;
    }
    @GetMapping("/Persona/{id}")
    public ResponseEntity<String> obtenerPersonaPorId(@PathVariable Long id) {//Buscar un objeto por id en tu base de datos
        try {//Este try si resuelve va a mostrar al objeto buscado por id si ese objeto existe sino va a devolver un "ERROR404"
            Persona persona = personaService.obtenerPersonaPorId(id);
            if (persona != null) {
                return ResponseEntity.ok("Id:" + persona);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR404: Id not found");
            }
        } catch (PersonaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR404: " + e.getMessage());
        }
    }
    @PostMapping("/Persona")
    public HttpEntity agregarPersona(@RequestBody Persona persona){//Crear un objeto en tu base de datos
        return personaService.registrarPersona(persona);
    }
    @DeleteMapping("/Persona/{id}")
    private ResponseEntity<String> eliminarPersona(@PathVariable Long id) {// Eliminar un objeto de tu base de datos por id
        try {//Este try si resuelve va a eliminar al objeto
            personaService.deletePersonaById(id);
            return ResponseEntity.ok("Persona eliminada correctamente");
        } catch (PersonaNotFoundException e) {//Este catch va a devolver un error si el try no resolvio
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR404: Id not found");
        }
    }
}

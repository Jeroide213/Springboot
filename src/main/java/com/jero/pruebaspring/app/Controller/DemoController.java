package com.jero.pruebaspring.app.Controller;

import com.jero.pruebaspring.app.Exceptions.PersonaNotFoundException;
import com.jero.pruebaspring.app.Service.IPersonaService;
import com.jero.pruebaspring.app.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
@CrossOrigin
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
    @GetMapping("/Persona/{idPersona}")
    public ResponseEntity<Object> obtenerPersonaPorId(@PathVariable Long idPersona) {
        ResponseEntity<Persona> persona = personaService.obtenerPersonaPorId(idPersona);
        if (persona != null) {
            return ResponseEntity.ok(persona);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", HttpStatus.NOT_FOUND.value());
            errorResponse.put("error", "Not Found");
            errorResponse.put("message", "No se encontró la persona con ID: " + idPersona);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    @PostMapping("/Persona")
    public HttpEntity agregarPersona(@RequestBody Persona persona){//Crear un objeto en tu base de datos
        return personaService.registrarPersona(persona);
    }
    @DeleteMapping("/Persona/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable Long idPersona) {// Eliminar un objeto de tu base de datos por id
        try {//Este try si resuelve va a eliminar al objeto
            personaService.deletePersonaById(idPersona);
            return ResponseEntity.ok("Persona eliminada correctamente");
        } catch (PersonaNotFoundException e) {//Este catch va a devolver un error si el try no resolvio
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR404: Id not found");
        }
    }
}
package com.jero.pruebaspring.app.Service;
import com.jero.pruebaspring.app.Exceptions.PersonaNotFoundException;
import com.jero.pruebaspring.app.model.Persona;
import com.jero.pruebaspring.app.repository.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService {//Esta clase tipo servicio implementa todos los metodos en la interfaz

    @Autowired
    private IPersonaRepo personaRepo;

    @Override
    public ResponseEntity<Persona> registrarPersona(Persona persona) {
        try {
            // Validación de datos
            if (persona.getIdPersona() != null && persona.getEdad() != 0 && persona.getApellido() != null) {
                // Operación principal
                Persona personaGuardada = personaRepo.save(persona);
                return new ResponseEntity<>(personaGuardada, HttpStatus.CREATED);
            } else {
                // Datos no válidos
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Manejo adecuado de excepciones
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public List<Persona> findPersonaAll() {
        // Implementa la lógica para obtener todas las personas
        return personaRepo.findAll();
    }
    @Override
    public Persona obtenerPersonaPorId(Long id){//Implementa la logica para buscar un solo objeto por id
        Optional<Persona> personaOptional = personaRepo.findById(id);
        return personaOptional.orElse(null);
    }
    @Override
    public ResponseEntity<Persona> deletePersonaById(Long idPersona) {//Implementa la logica para borrar un objeto por id
        Optional<Persona> personaOptional = personaRepo.findById(idPersona);

        if (personaOptional.isPresent()) {
            personaRepo.deleteById(idPersona);
            return ResponseEntity.ok(personaOptional.get());
        } else {
            throw new PersonaNotFoundException("Persona con ID " + idPersona + " no encontrada");
        }
    }
}
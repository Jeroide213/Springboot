package com.jero.pruebaspring.app.Service;

import com.jero.pruebaspring.app.model.Persona;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPersonaService {//Esto sirve para definir un conjunto de metodos que son implementados en una clase tipo @Service
    ResponseEntity registrarPersona(Persona persona);//Metodo que crea un objeto

    ResponseEntity<Persona> deletePersonaById(Long idPersona);//Metodo que elimina de la base de datos un objeto

    List<Persona> findPersonaAll();//Metodo que devuelve una lista de todos los objetos

    Persona obtenerPersonaPorId(Long id);//Metodo que devuelve solo un objeto
}
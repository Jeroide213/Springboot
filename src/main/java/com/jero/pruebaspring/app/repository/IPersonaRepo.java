package com.jero.pruebaspring.app.repository;
import com.jero.pruebaspring.app.model.Persona;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepo extends MongoRepository<Persona, Long> {//Este repository va a dejar que puedas usar metodos tipo CRUD

}
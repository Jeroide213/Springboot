package com.jero.pruebaspring.app.repository;
import com.jero.pruebaspring.app.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {//Este repository va a dejar que puedas usar metodos tipo CRUD

}
package com.jero.pruebaspring.app.Controller;

public class PersonaNotFoundException extends RuntimeException {//Esta clase va a servir para generar los errores del controlador

    public PersonaNotFoundException(String message) {
        super(message);
    }
}
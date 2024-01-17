package com.jero.pruebaspring.app.model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Persona {//Esta clase es una entidad, por ende se puede almacenar en una base de datos


    public Persona() {//Constructor vacio recomendado por Gratto (Y)
    }
    public Persona(Long idPersona, String nombre, String apellido, Integer edad, Integer telefono) {//Constructor de objeto Persona
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
    }

    @Id//Con esto indicamos que la variable idPersona es la clave primaria para buscar a nuestros objetos en la base de datos
    private Long idPersona;
    @Field//Las columnas especifican detalles sobre como los campos de la entidad deben ser mapeados
    private String nombre;
    @Field
    private String apellido;
    @Field
    private Integer edad;
    @Field
    private Integer telefono;
//Abajo de aca estan los setters and getters
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad(int i) {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getTelefono(int i) {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}

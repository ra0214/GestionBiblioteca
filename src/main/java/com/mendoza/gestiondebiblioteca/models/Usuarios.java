package com.mendoza.gestiondebiblioteca.models;

public class Usuarios extends Personas{

    private int id;

    public Usuarios(String nombre, String apellido, int edad, int id) {
        super(nombre, apellido, edad);
        this.id = id;
    }
}

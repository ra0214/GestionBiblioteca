package com.mendoza.gestiondebiblioteca.models;

public class Alumnos extends Persona {

    private String grado;

    public Alumnos(String nombre, String apellidos, String edad, String grado) {
        super(nombre, apellidos, edad);
        this.grado = grado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}

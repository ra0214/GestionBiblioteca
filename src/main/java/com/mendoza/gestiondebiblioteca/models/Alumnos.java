package com.mendoza.gestiondebiblioteca.models;

public class Alumnos extends Persona {
    private static int contadorId = 1;
    private int id;
    private String grado;

    public Alumnos(String nombre, String apellidos, String edad, String grado) {
        super(nombre, apellidos, edad);
        this.id = contadorId++;
        this.grado = grado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}

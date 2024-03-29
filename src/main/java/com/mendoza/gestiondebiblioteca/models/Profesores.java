package com.mendoza.gestiondebiblioteca.models;

public class Profesores extends Persona{
    private String area;

    public Profesores(String nombre, String apellidos, String edad, String area) {
        super(nombre, apellidos, edad);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

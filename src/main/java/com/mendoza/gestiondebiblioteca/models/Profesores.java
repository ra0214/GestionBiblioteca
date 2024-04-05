package com.mendoza.gestiondebiblioteca.models;

public class Profesores extends Persona{
    private static int contadorId=1;
    private int id;
    private String area;

    public Profesores(String nombre, String apellidos, String edad, String area) {
        super(nombre, apellidos, edad);
        this.id = contadorId++;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

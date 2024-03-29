package com.mendoza.gestiondebiblioteca.models;

import java.util.ArrayList;

public class Persona {

    private String nombre;
    private String edad;
    private String apellidos;

    private ArrayList<Alumnos> listaAlumnos;
    private ArrayList<Profesores> listaProfesores;

    public Persona() {
        listaAlumnos = new ArrayList<>();
        listaProfesores = new ArrayList<>();
    }

    public ArrayList<Alumnos> getListaAlumnos() {
        return listaAlumnos;
    }

    public ArrayList<Profesores> getListaProfesores(){
        return listaProfesores;
    }

    public Persona(String nombre, String apellidos, String edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellidos = apellidos;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}

package com.mendoza.gestiondebiblioteca.models;

import java.util.ArrayList;
import java.util.Date;

public class Prestamos {
    private Persona persona;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucion;

    private ArrayList<Prestamos> listaPrestamos;

    public Prestamos() {
        listaPrestamos = new ArrayList<>();
    }

    public ArrayList<Prestamos> getListaPrestamos() {
        return listaPrestamos;
    }


    public Prestamos(Libro libro, Persona persona, String fechaPrestamo, String fechaDevolucion) {
        this.persona = persona;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}

package com.mendoza.gestiondebiblioteca.models;

import java.util.ArrayList;
import java.util.Date;

public class Prestamos {
    private String persona;
    private String libro;
    private String fechaPrestamo;
    private String fechaDevolucion;

    private ArrayList<Prestamos> listaPrestamos;

    public Prestamos() {
        listaPrestamos = new ArrayList<>();
    }

    public ArrayList<Prestamos> getListaPrestamos() {
        return listaPrestamos;
    }


    public Prestamos(String persona, String libro, String fechaPrestamo, String fechaDevolucion) {
        this.persona = persona;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
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

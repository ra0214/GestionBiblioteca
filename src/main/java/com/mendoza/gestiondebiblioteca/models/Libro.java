package com.mendoza.gestiondebiblioteca.models;

import java.util.ArrayList;

public class Libro {
    private String id;
    private String titulo;
    private String autor;
    private String editorial;
    private String cantidadDisponible;
    private String fechaPublicacion;

    private ArrayList<Libro> listaLibros;

    public Libro() {
        listaLibros = new ArrayList<>();
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public Libro(String id, String titulo, String autor, String editorial, String cantidadDisponible, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.cantidadDisponible = cantidadDisponible;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(String cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}


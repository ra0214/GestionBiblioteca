package com.mendoza.gestiondebiblioteca.models;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Persona> listaUsuarios;
    private ArrayList<Libro> listaLibros;

    public Biblioteca() {
        listaUsuarios = new ArrayList<>();
        listaLibros = new ArrayList<>();
    }

    public ArrayList<Persona> getListaUsuarios(){
        return listaUsuarios;
    }

    public void agregarUsuario(Persona persona) {
        listaUsuarios.add(persona);
    }

    public void eliminarUsuario(Persona persona) {
        listaUsuarios.remove(persona);
    }

    public Persona buscarPersona(String nombre) {
        for (Persona persona : listaUsuarios) {
            if (persona.getNombre().equals(nombre)) {
                return persona;
            }
        }
        return null;
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        listaLibros.remove(libro);
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }
}

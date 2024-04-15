package com.mendoza.gestiondebiblioteca;

import com.mendoza.gestiondebiblioteca.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Application extends javafx.application.Application {

    private static Persona persona = new Persona();

    private static Libro libro = new Libro();

    private static Prestamos prestamo = new Prestamos();

    private static ArrayList<Alumnos> listaAlumnos = new ArrayList<>();

    private static ArrayList<Profesores> listaProfesores = new ArrayList<>();

    private static ObservableList<Prestamos> prestamos = FXCollections.observableArrayList();

    private static ObservableList<Libro> libros = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Gestión De Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    public static void agregarAlumno(Alumnos alumno) {
        listaAlumnos.add(alumno);
    }

    public static void agregarProfesor(Profesores profesor) {
        listaProfesores.add(profesor);
    }

    public static ArrayList<Alumnos> getListaAlumnos() {
        return listaAlumnos;
    }

    public  static ArrayList<Profesores> getListaProfesores() {
        return listaProfesores;
    }

    public static Persona getPersona() {
        return persona;
    }

    public static Libro getLibro() {
        return libro;
    }

    public static Prestamos getPrestamo() {
        return prestamo;
    }

    public static ObservableList<Prestamos> getPrestamos() {
        return prestamos;
    }

    public static ObservableList<Libro> getLibros() {
        return libros;
    }

    public static void main(String[] args) {
        launch();
    }
}

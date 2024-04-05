package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Biblioteca;
import com.mendoza.gestiondebiblioteca.models.Libro;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AgregarLibroController {

    @FXML
    private Button agregarBtn;

    @FXML
    private TextField nomlibroTxt;

    @FXML
    private TextField autorTxt;

    @FXML
    private TextField cantidadTxt;

    @FXML
    private TextField editorialTxt;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField fechaTxt;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Button salirBtn;



    @FXML
    void OnClickedAgregarBtn(MouseEvent event) {
        ArrayList<Libro> libros = Application.getLibro().getListaLibros();
        String id = idTxt.getText();
        String titulo = nomlibroTxt.getText();
        String autor = autorTxt.getText();
        String editorial = editorialTxt.getText();
        String cantidad = cantidadTxt.getText();
        String fecha = fechaTxt.getText();


        Libro libro = new Libro(id,titulo,autor,editorial, cantidad, fecha);

        if (libros.add(libro)) {
            mostrarAlerta("Éxito", "Se ha agregado un nuevo libro.");

            System.out.println("Se ha agregado un nuevo libro:");
            System.out.println("ID: "+libro.getId());
            System.out.println("Título: "+libro.getTitulo());
            System.out.println("Autor: "+libro.getAutor());
            System.out.println("Editorial: "+libro.getEditorial());
            System.out.println("Cantidad: "+libro.getCantidadDisponible());
            System.out.println("Fecha: "+libro.getFechaPublicacion());
        }

        limpiarCampos();
    }

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menuSuper-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Menú De Super Administrador");
        stage.show();
    }

    private void limpiarCampos() {
        nomlibroTxt.clear();
        autorTxt.clear();
        editorialTxt.clear();
        idTxt.clear();
        cantidadTxt.clear();
        fechaTxt.clear();
    }



    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

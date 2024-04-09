package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Libro;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ActualizarDatosController {

    @FXML
    private Label EditorialLabel;

    @FXML
    private Button actualizarBtn;

    @FXML
    private Label autorLabel;

    @FXML
    private TextField autorTxt;

    @FXML
    private Label cantidadLabel;

    @FXML
    private TextField cantidadTxt;

    @FXML
    private TextField editorialTxt;

    @FXML
    private Label fechaLabel;

    @FXML
    private Label fechaLabel1;

    @FXML
    private TextField fechaTxt;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTxt;

    @FXML
    private Label midLabel;

    @FXML
    private TextField midTxt;

    @FXML
    private Button mostrarBtn;

    @FXML
    private TextField nomlibroTxt;

    @FXML
    private Button regresarBtn;

    @FXML
    private Button salirBtn;

    @FXML
    private Label tituloLabel;

    @FXML
    void OnClickedActualizarBtn(MouseEvent event) {
        String id = idTxt.getText();
        String titulo = nomlibroTxt.getText();
        String autor = autorTxt.getText();
        String editorial = editorialTxt.getText();
        String cantidad = cantidadTxt.getText();
        String fecha = fechaTxt.getText();

        if (!id.isEmpty() && !titulo.isEmpty() && !autor.isEmpty() && !editorial.isEmpty() && !cantidad.isEmpty() && !fecha.isEmpty()) {
            ObservableList<Libro> list = Application.getLibros();
            //ArrayList<Libro> listaLibros = Application.getLibro().getListaLibros();

            //Libro libroActualizado = null;
            for (int i =0; i<list.size();i++) {
                Libro libro = list.get(i);
                if (libro.getId().equals(id)) {
                    libro.setTitulo(titulo);
                    libro.setAutor(autor);
                    libro.setEditorial(editorial);
                    libro.setCantidadDisponible(cantidad);
                    libro.setFechaPublicacion(fecha);

                    list.set(i, libro);

                    System.out.println("Título: "+libro.getTitulo());
                    System.out.println("Autor: "+libro.getAutor());
                    System.out.println("Editorial: "+libro.getEditorial());
                    System.out.println("Cantidad: "+libro.getCantidadDisponible());
                    System.out.println("Fecha: "+libro.getFechaPublicacion());

                    mostrarAlerta("Actualización Exitosa", "Los datos del libro han sido actualizados correctamente.");


                    limpiarCampos();
                    return;
                }
            }
            mostrarAlerta("Error", "No se encontró ningún libro con ese id");
        } else {
            mostrarAlerta("Error", "Por favor complete todos los campos.");
        }
    }

    @FXML
    void OnClickedMostrarBtn(MouseEvent event) {
        String idBuscado = idTxt.getText();
        //ArrayList<Libro> listaLibros = Application.getLibro().getListaLibros();
        ObservableList<Libro> list = Application.getLibros();

        Libro libroEncontrado = null;
        for (Libro libros : list) {
            if (libros.getId().equals(idBuscado)) {
                libroEncontrado = libros;
                break;
            }
        }

        if (libroEncontrado != null){
            mostrarAlerta("Búsqueda Exitosa", "Se encontró el libro buscado.");

            midLabel.setVisible(true);
            midTxt.setVisible(true);
            tituloLabel.setVisible(true);
            nomlibroTxt.setVisible(true);
            autorTxt.setVisible(true);
            autorLabel.setVisible(true);
            EditorialLabel.setVisible(true);
            editorialTxt.setVisible(true);
            cantidadLabel.setVisible(true);
            cantidadTxt.setVisible(true);
            fechaLabel.setVisible(true);
            fechaTxt.setVisible(true);
            actualizarBtn.setVisible(true);
            regresarBtn.setVisible(true);

            midTxt.setText(String.valueOf(libroEncontrado.getId()));
            nomlibroTxt.setText(String.valueOf(libroEncontrado.getTitulo()));
            autorTxt.setText(String.valueOf(libroEncontrado.getAutor()));
            editorialTxt.setText(String.valueOf(libroEncontrado.getEditorial()));
            cantidadTxt.setText(String.valueOf(libroEncontrado.getCantidadDisponible()));
            fechaTxt.setText(String.valueOf(libroEncontrado.getFechaPublicacion()));

            idTxt.setVisible(false);
            idLabel.setVisible(false);
            mostrarBtn.setVisible(false);
            salirBtn.setVisible(false);
        } else {
            mostrarAlerta("Error", "No se encontró ningún libro con ese ID");
        }
        limpiarCampos();
    }

    @FXML
    void OnClickedRegresarBtn(MouseEvent event) {
        midLabel.setVisible(false);
        midTxt.setVisible(false);
        tituloLabel.setVisible(false);
        nomlibroTxt.setVisible(false);
        autorTxt.setVisible(false);
        autorLabel.setVisible(false);
        EditorialLabel.setVisible(false);
        editorialTxt.setVisible(false);
        cantidadLabel.setVisible(false);
        cantidadTxt.setVisible(false);
        fechaLabel.setVisible(false);
        fechaTxt.setVisible(false);
        regresarBtn.setVisible(false);
        actualizarBtn.setVisible(false);

        midTxt.clear();
        nomlibroTxt.clear();
        autorTxt.clear();
        editorialTxt.clear();
        cantidadTxt.clear();
        fechaTxt.clear();

        idTxt.setVisible(true);
        idLabel.setVisible(true);
        mostrarBtn.setVisible(true);
        salirBtn.setVisible(true);
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

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        idTxt.clear();
    }
}

package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Libro;
import javafx.collections.ObservableList;
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

public class EliminarLibroController {

    @FXML
    private TextField autorTxt;

    @FXML
    private Button eliminarBtn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TextField nomlibroTxt;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedEliminarBtn(MouseEvent event) {
        String titulo = nomlibroTxt.getText();
        String autor = autorTxt.getText();

        //ArrayList<Libro> listaLibros = Application.getLibro().getListaLibros();
        ObservableList<Libro> list = Application.getLibros();

        Libro libroEliminar = null;
        for (Libro libro : list) {
            if (libro.getTitulo().equals(titulo) && libro.getAutor().equals(autor)) {
                libroEliminar = libro;
                break;
            }
        }

        if (libroEliminar != null){
            list.remove(libroEliminar);
            mostrarAlerta("Éxito", "Se ha eliminado el libro correctamente.");
        } else {
            mostrarAlerta("Error", "No se encontró un libro con ese título y autor.");
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

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        nomlibroTxt.clear();
        autorTxt.clear();
    }
}

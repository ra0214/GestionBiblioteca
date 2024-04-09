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

public class BuscaLibroController {

    @FXML
    private TextField autorTxt;

    @FXML
    private Label autorlabel;

    @FXML
    private Button buscarBtn;

    @FXML
    private Label cantidadLabel;

    @FXML
    private TextField cantidadTxt;

    @FXML
    private Label editorialLabel;

    @FXML
    private TextField editorialTxt;

    @FXML
    private Label fechaLabel;

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
    private TextField nomlibroTxt;

    @FXML
    private Button salirBtn;

    @FXML
    private Label tituloLabel;

    @FXML
    void OnClickedBuscarBtn(MouseEvent event) {
        String idbuscado = this.idTxt.getText();
        ObservableList<Libro> list = Application.getLibros();
        //ArrayList<Libro> listaLibros = Application.getLibro().getListaLibros();

        Libro libroEncontrado = null;
        for (Libro libros : list) {
            if (libros.getId().equals(idbuscado)){
                libroEncontrado = libros;
                break;
            }
        }

        if (libroEncontrado != null) {
            mostrarAlerta("Búsqueda Exitosa", "Se encontro el libro buscado.");
            midLabel.setVisible(true);
            midTxt.setVisible(true);
            tituloLabel.setVisible(true);
            nomlibroTxt.setVisible(true);
            autorTxt.setVisible(true);
            autorlabel.setVisible(true);
            editorialLabel.setVisible(true);
            editorialTxt.setVisible(true);
            cantidadLabel.setVisible(true);
            cantidadTxt.setVisible(true);
            fechaLabel.setVisible(true);
            fechaTxt.setVisible(true);

            midTxt.setText(String.valueOf(libroEncontrado.getId()));
            nomlibroTxt.setText(String.valueOf(libroEncontrado.getTitulo()));
            autorTxt.setText(String.valueOf(libroEncontrado.getAutor()));
            editorialTxt.setText(String.valueOf(libroEncontrado.getEditorial()));
            cantidadTxt.setText(String.valueOf(libroEncontrado.getCantidadDisponible()));
            fechaTxt.setText(String.valueOf(libroEncontrado.getFechaPublicacion()));
        } else {
            mostrarAlerta("Error", "No se encontró ningún libro con ese ID");
        }
        limpiarCampos();
    }

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menuAdmin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Menú De Administrador");
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

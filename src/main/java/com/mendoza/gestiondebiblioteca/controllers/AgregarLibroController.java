package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Biblioteca;
import com.mendoza.gestiondebiblioteca.models.Libro;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AgregarLibroController {

    @FXML
    private Button agregarBtn;

    @FXML
    private TextField nomlibroTxt;

    @FXML
    private TextField autorTxt;

    @FXML
    private TextField editorialTxt;

    @FXML
    private TextField idTxt;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Button salirBtn;

    private Biblioteca biblioteca;

    public AgregarLibroController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @FXML
    void OnClickedAgregarBtn(MouseEvent event) {
        String titulo = nomlibroTxt.getText();
        String autor = autorTxt.getText();
        String editorial = editorialTxt.getText();
        String id = idTxt.getText();

        Libro libro = new Libro(id,titulo,autor,editorial);
        biblioteca.agregarLibro(libro);

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
    }

}

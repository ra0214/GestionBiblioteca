package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Prestamos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PrestamoController {

    @FXML
    private Button agregarBtn;

    @FXML
    private Label fechainLabel;

    @FXML
    private Label fechafinLabel;

    @FXML
    private TextField fechainTxt;

    @FXML
    private TextField fechafinTxt;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Label nombreLabel;

    @FXML
    private TextField nombreTxt;

    @FXML
    private Button salirBtn;

    @FXML
    private Label tituloLabel;

    @FXML
    private TextField tituloTxt;

    @FXML
    void OnClickedAgregarBtn(MouseEvent event) {
        ArrayList<Prestamos> prestamos = Application.getPrestamo().getListaPrestamos();
        String titulo = tituloTxt.getText();
        String nombre = nombreTxt.getText();
        String fechaIn = fechainTxt.getText();
        String fechaFin = fechafinTxt.getText();

       // Prestamos prestamo = new Prestamos(titulo,nombre, fechaIn, fechaFin) {}
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

}

package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Prestamos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrestamosController {

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
        //ArrayList<Prestamos> prestamos = Application.getPrestamo().getListaPrestamos();
        String titulo = tituloTxt.getText();
        String nombre = nombreTxt.getText();
        String fechaIn = fechainTxt.getText();
        String fechaFin = fechafinTxt.getText();

        Prestamos prestamo = new Prestamos(titulo,nombre, fechaIn, fechaFin);

        if (!Application.getPrestamos().contains(prestamo)) {
            Application.getPrestamos().add(prestamo);

            mostrarAlerta("Éxito", "Se ha agregado un nuevo prestamo.");

            System.out.println("Nuevo prestamo: ");
            System.out.println("Usuario: "+prestamo.getPersona());
            System.out.println("Libro: "+prestamo.getLibro());
            System.out.println("Fecha de prestamo: "+prestamo.getFechaPrestamo());
            System.out.println("Fecha de devolución: "+prestamo.getFechaDevolucion());
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

    private void limpiarCampos() {
        tituloTxt.clear();
        nombreTxt.clear();
        fechainTxt.clear();
        fechafinTxt.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

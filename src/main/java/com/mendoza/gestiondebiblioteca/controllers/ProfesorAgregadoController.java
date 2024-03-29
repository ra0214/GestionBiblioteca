package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
import com.mendoza.gestiondebiblioteca.models.Profesores;
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

public class ProfesorAgregadoController {

    @FXML
    private Button agregarBtn;

    @FXML
    private TextField apellidosTxt;

    @FXML
    private TextField areaTxt;

    @FXML
    private TextField edadTxt;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TextField nombreTxt;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedAgregarBtn(MouseEvent event) {
        ArrayList<Profesores> profesores = Application.getPersona().getListaProfesores();
        String nombre = nombreTxt.getText();
        String apellidos = apellidosTxt.getText();
        String edad = edadTxt.getText();
        String area = areaTxt.getText();

        Profesores profesor = new Profesores(nombre, apellidos, edad, area);

        if (profesores.add(profesor)) {
            mostrarAlerta("Éxito", "Se ha agregado un nuevo usuario.");

            System.out.println("Se ha agregado un nuevo usuario:");
            System.out.println("Nombre: " + profesor.getNombre());
            System.out.println("Apellidos: " + profesor.getApellidos());
            System.out.println("Edad: " + profesor.getEdad());
            System.out.println("Área: "+profesor.getArea());
        }
        limpiarCampos();
    }

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("agregarUsuario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Agregar Usuario");
        stage.show();
    }

    private void limpiarCampos() {
        nombreTxt.clear();
        apellidosTxt.clear();
        edadTxt.clear();
        areaTxt.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}

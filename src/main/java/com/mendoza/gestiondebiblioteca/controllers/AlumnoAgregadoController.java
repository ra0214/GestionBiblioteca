package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
import com.mendoza.gestiondebiblioteca.models.Persona;
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

public class AlumnoAgregadoController {

    @FXML
    private Button agregarBtn;

    @FXML
    private TextField apellidosTxt;

    @FXML
    private TextField edadTxt;

    @FXML
    private TextField gradoTxt;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TextField nombreTxt;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedAgregarBtn(MouseEvent event) {
        ArrayList<Alumnos> alumnos = Application.getPersona().getListaAlumnos();
        String nombre = nombreTxt.getText();
        String apellidos = apellidosTxt.getText();
        String edad = edadTxt.getText();
        String grado = gradoTxt.getText();

        Alumnos alumno = new Alumnos(nombre, apellidos, edad, grado);

        if (alumnos.add(alumno)) {
            mostrarAlerta("Éxito", "Se ha agregado un nuevo usuario.");

            System.out.println("Se ha agregado un nuevo usuario:");
            System.out.println("ID: " + alumno.getId());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellidos: " + alumno.getApellidos());
            System.out.println("Edad: " + alumno.getEdad());
            System.out.println("Grado: "+alumno.getGrado());
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
        gradoTxt.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}


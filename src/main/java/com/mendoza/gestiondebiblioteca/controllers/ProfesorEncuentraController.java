package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Profesores;
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

public class ProfesorEncuentraController {

    @FXML
    private Label apellidosLabel;

    @FXML
    private TextField apellidosTxt;

    @FXML
    private Label areaLabel;

    @FXML
    private TextField areaTxt;

    @FXML
    private Button buscarBtn;

    @FXML
    private Label edadLabel;

    @FXML
    private TextField edadTxt;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTxt;

    @FXML
    private Label nombreLabel;

    @FXML
    private TextField nombreTxt;

    @FXML
    private TextField nombresTxt;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedBuscarBtn(MouseEvent event) {
        String nombreBuscado = nombreTxt.getText();
        ArrayList<Profesores> listaProfesores = Application.getPersona().getListaProfesores();

        Profesores profesorEncontrado = null;
        for (Profesores profesores : listaProfesores) {
            if (profesores.getNombre().equals(nombreBuscado)) {
                profesorEncontrado = profesores;
                break;
            }
        }

        if (profesorEncontrado != null) {
            mostrarAlerta("Búsqueda Exitosa", "Se encontró el profesor buscado");

            idLabel.setVisible(true);
            nombreLabel.setVisible(true);
            apellidosLabel.setVisible(true);
            edadLabel.setVisible(true);
            areaLabel.setVisible(true);
            idTxt.setVisible(true);
            nombresTxt.setVisible(true);
            apellidosTxt.setVisible(true);
            edadTxt.setVisible(true);
            areaTxt.setVisible(true);

            idTxt.setText(String.valueOf(profesorEncontrado.getId()));
            nombresTxt.setText(profesorEncontrado.getNombre());
            apellidosTxt.setText(profesorEncontrado.getApellidos());
            edadTxt.setText(profesorEncontrado.getEdad());
            areaTxt.setText(profesorEncontrado.getArea());

            System.out.println("Profesor encontrado:");
            System.out.println("ID: " + profesorEncontrado.getId());
            System.out.println("Nombre: " + profesorEncontrado.getNombre());
            System.out.println("Apellidos: " + profesorEncontrado.getApellidos());
            System.out.println("Edad: " + profesorEncontrado.getEdad());
            System.out.println("Área: " + profesorEncontrado.getArea());
        } else {
            mostrarAlerta("Error", "No se encontró ningún profesor con ese nombre.");
        }
        limpiarCampos();
    }

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("usuarioBuscado-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Buscar Usuario");
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
        nombreTxt.clear();
    }

}

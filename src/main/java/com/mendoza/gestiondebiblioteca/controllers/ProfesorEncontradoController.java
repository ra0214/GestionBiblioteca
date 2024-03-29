package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
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

public class ProfesorEncontradoController {

    @FXML
    private Button buscarBtn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TextField nombreTxt;

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

            System.out.println("Alumno encontrado:");
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

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("buscarUsuario-view.fxml"));
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

package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
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

public class AlumnoActualizarController {

    @FXML
    private AnchorPane fondo;

    @FXML
    private Button mostrarBtn;

    @FXML
    private TextField nombreTxt;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedMostrarBtn(MouseEvent event) throws IOException {
        String nombreBuscado = nombreTxt.getText();
        ArrayList<Alumnos> listaAlumnos = Application.getPersona().getListaAlumnos();

        Alumnos alumnoEncontrado = null;
        for (Alumnos alumnos : listaAlumnos) {
            if (alumnos.getNombre().equals(nombreBuscado)) {
                alumnoEncontrado = alumnos;
                break;
            }
        }

        if (alumnoEncontrado != null) {
            mostrarAlerta("Búsqueda Exitosa", "Se encontró el alumno buscado");

            Stage currentStage = (Stage) fondo.getScene().getWindow();
            currentStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("alumnoActualizado-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Actualizar Datos");
            stage.show();
        } else {
            mostrarAlerta("Error", "No se encontró ningún alumno con ese nombre.");
        }
        limpiarCampos();
    }

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("actualizarDatosUsuario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Actualizar Datos");
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

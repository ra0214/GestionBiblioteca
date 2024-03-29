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

public class AlumnoEliminadoController {

    @FXML
    private TextField apellidosTxt;

    @FXML
    private Button eliminarBtn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TextField nombreTxt;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedEliminarBtn(MouseEvent event) {
        String nombre = nombreTxt.getText();
        String apellidos = apellidosTxt.getText();

        ArrayList<Alumnos> listaAlumnos = Application.getPersona().getListaAlumnos();

        Alumnos alumnoAEliminar = null;
        for (Alumnos alumno : listaAlumnos) {
            if (alumno.getNombre().equals(nombre) && alumno.getApellidos().equals(apellidos)) {
                alumnoAEliminar = alumno;
                break;
            }
        }

        if (alumnoAEliminar != null) {
            listaAlumnos.remove(alumnoAEliminar);
            mostrarAlerta("Éxito", "Se ha eliminado el usuario correctamente.");
        } else {
            mostrarAlerta("Error", "No se encontró ningún alumno con ese nombre y apellidos.");
        }
        limpiarCampos();
    }

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("eliminarUsuario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Eliminar Usuario");
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
        apellidosTxt.clear();
    }

}

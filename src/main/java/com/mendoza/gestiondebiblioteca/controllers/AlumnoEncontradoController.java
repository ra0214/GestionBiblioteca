package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
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

public class AlumnoEncontradoController {
    @FXML
    private Label apellidosLabel;

    @FXML
    private TextField apellidosTxt;

    @FXML
    private Button buscarBtn;

    @FXML
    private Label edadLabel;

    @FXML
    private TextField edadTxt;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Label gradoLabel;

    @FXML
    private TextField gradoTxt;

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

            idLabel.setVisible(true);
            nombreLabel.setVisible(true);
            apellidosLabel.setVisible(true);
            edadLabel.setVisible(true);
            gradoLabel.setVisible(true);
            idTxt.setVisible(true);
            nombresTxt.setVisible(true);
            apellidosTxt.setVisible(true);
            edadTxt.setVisible(true);
            gradoTxt.setVisible(true);

            idTxt.setText(String.valueOf(alumnoEncontrado.getId()));
            nombresTxt.setText(alumnoEncontrado.getNombre());
            apellidosTxt.setText(alumnoEncontrado.getApellidos());
            edadTxt.setText(alumnoEncontrado.getEdad());
            gradoTxt.setText(alumnoEncontrado.getGrado());

            System.out.println("Alumno encontrado:");
            System.out.println("ID: " + alumnoEncontrado.getId());
            System.out.println("Nombre: " + alumnoEncontrado.getNombre());
            System.out.println("Apellidos: " + alumnoEncontrado.getApellidos());
            System.out.println("Edad: " + alumnoEncontrado.getEdad());
            System.out.println("Grado: " + alumnoEncontrado.getGrado());
        } else {
            mostrarAlerta("Error", "No se encontró ningún alumno con ese nombre.");
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

    public void initialize() {

    }
}

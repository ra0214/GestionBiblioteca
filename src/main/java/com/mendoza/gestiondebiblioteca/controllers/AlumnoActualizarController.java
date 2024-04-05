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

public class AlumnoActualizarController {

    @FXML
    private Button agregarBtn;

    @FXML
    private Label apellidoLabel;

    @FXML
    private TextField apellidosTxt;

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
    private Button mostrarBtn;

    @FXML
    private Label nameLabel;

    @FXML
    private Label nombreLabel;

    @FXML
    private TextField nombreTxt;

    @FXML
    private TextField nombresTxt;

    @FXML
    private Button regresarBtn;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedAgregarBtn(MouseEvent event) {
        String id = idTxt.getText();
        String nombre = nombresTxt.getText();
        String apellidos = apellidosTxt.getText();
        String edad = edadTxt.getText();
        String grado = gradoTxt.getText();

        if (!id.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() && !edad.isEmpty() && !grado.isEmpty()) {
            ArrayList<Alumnos> listaAlumnos = Application.getPersona().getListaAlumnos();

            for (int i = 0; i < listaAlumnos.size(); i++) {
                Alumnos alumno = listaAlumnos.get(i);
                if (alumno.getNombre().equals(nombre)) {

                    alumno.setId(Integer.parseInt(id));
                    alumno.setNombre(nombre);
                    alumno.setApellidos(apellidos);
                    alumno.setEdad(edad);
                    alumno.setGrado(grado);

                    listaAlumnos.set(i, alumno);

                    mostrarAlerta("Actualización Exitosa", "Los datos del alumno han sido actualizados correctamente.");

                    limpiarCampos();
                    OnClickedRegresarBtn(null);
                    return;
                }
            }
            mostrarAlerta("Error", "No se encontró ningún alumno con ese nombre.");
        } else {
            mostrarAlerta("Error", "Por favor complete todos los campos.");
        }
    }

    @FXML
    void OnClickedRegresarBtn(MouseEvent event) {
        idLabel.setVisible(false);
        nombreLabel.setVisible(false);
        apellidoLabel.setVisible(false);
        edadLabel.setVisible(false);
        gradoLabel.setVisible(false);
        idTxt.setVisible(false);
        nombresTxt.setVisible(false);
        apellidosTxt.setVisible(false);
        edadTxt.setVisible(false);
        gradoTxt.setVisible(false);
        agregarBtn.setVisible(false);
        regresarBtn.setVisible(false);

        nombreTxt.setVisible(true);
        nameLabel.setVisible(true);
        mostrarBtn.setVisible(true);
        salirBtn.setVisible(true);
    }

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

            idLabel.setVisible(true);
            nombreLabel.setVisible(true);
            apellidoLabel.setVisible(true);
            edadLabel.setVisible(true);
            gradoLabel.setVisible(true);
            idTxt.setVisible(true);
            nombresTxt.setVisible(true);
            apellidosTxt.setVisible(true);
            edadTxt.setVisible(true);
            gradoTxt.setVisible(true);
            agregarBtn.setVisible(true);
            regresarBtn.setVisible(true);

            idTxt.setText(String.valueOf(alumnoEncontrado.getId()));
            nombresTxt.setText(alumnoEncontrado.getNombre());
            apellidosTxt.setText(alumnoEncontrado.getApellidos());
            edadTxt.setText(alumnoEncontrado.getEdad());
            gradoTxt.setText(alumnoEncontrado.getGrado());

            nombreTxt.setVisible(false);
            nameLabel.setVisible(false);
            mostrarBtn.setVisible(false);
            salirBtn.setVisible(false);
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

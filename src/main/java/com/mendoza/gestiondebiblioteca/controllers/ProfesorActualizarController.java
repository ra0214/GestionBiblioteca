package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
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

public class ProfesorActualizarController {

    @FXML
    private Button agregarBtn;

    @FXML
    private Label apellidoLabel;

    @FXML
    private TextField apellidosTxt;

    @FXML
    private Label areaLabel;

    @FXML
    private TextField areaTxt;

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
        String area = areaTxt.getText();

        if (!id.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() && !edad.isEmpty() && !area.isEmpty()) {
            ArrayList<Profesores> listaProfesores = Application.getPersona().getListaProfesores();
            int idBuscado = Integer.parseInt(id);

            for (int i = 0; i < listaProfesores.size(); i++) {
                Profesores profesor = listaProfesores.get(i);
                if (profesor.getId() == idBuscado) {

                    profesor.setId(Integer.parseInt(id));
                    profesor.setNombre(nombre);
                    profesor.setApellidos(apellidos);
                    profesor.setEdad(edad);
                    profesor.setArea(area);

                    listaProfesores.set(i, profesor);

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
    void OnClickedMostrarBtn(MouseEvent event) {
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
            mostrarAlerta("Búsqueda Exitosa", "Se encontró el alumno buscado");

            idLabel.setVisible(true);
            nombreLabel.setVisible(true);
            apellidoLabel.setVisible(true);
            edadLabel.setVisible(true);
            areaLabel.setVisible(true);
            idTxt.setVisible(true);
            nombresTxt.setVisible(true);
            apellidosTxt.setVisible(true);
            edadTxt.setVisible(true);
            areaTxt.setVisible(true);
            agregarBtn.setVisible(true);
            regresarBtn.setVisible(true);

            idTxt.setText(String.valueOf(profesorEncontrado.getId()));
            nombresTxt.setText(profesorEncontrado.getNombre());
            apellidosTxt.setText(profesorEncontrado.getApellidos());
            edadTxt.setText(profesorEncontrado.getEdad());
            areaTxt.setText(profesorEncontrado.getArea());

            nombreTxt.setVisible(false);
            nameLabel.setVisible(false);
            mostrarBtn.setVisible(false);
            salirBtn.setVisible(false);
        } else {
            mostrarAlerta("Error", "No se encontró ningún profesor con ese nombre.");
        }
        limpiarCampos();
    }

    @FXML
    void OnClickedRegresarBtn(MouseEvent event) {
        idLabel.setVisible(false);
        nombreLabel.setVisible(false);
        apellidoLabel.setVisible(false);
        edadLabel.setVisible(false);
        areaLabel.setVisible(false);
        idTxt.setVisible(false);
        nombresTxt.setVisible(false);
        apellidosTxt.setVisible(false);
        edadTxt.setVisible(false);
        areaTxt.setVisible(false);
        agregarBtn.setVisible(false);
        regresarBtn.setVisible(false);

        nombreTxt.setVisible(true);
        nameLabel.setVisible(true);
        mostrarBtn.setVisible(true);
        salirBtn.setVisible(true);
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

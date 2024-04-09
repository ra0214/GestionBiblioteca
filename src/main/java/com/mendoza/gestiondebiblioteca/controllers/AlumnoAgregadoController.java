package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
import com.mendoza.gestiondebiblioteca.models.Persona;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    private TableColumn apellidoColumn;

    @FXML
    private TableColumn edadColumn;

    @FXML
    private TableColumn gradoColumn;

    @FXML
    private TableColumn idcolumn;

    @FXML
    private TableView<Persona> mostrarTable;

    @FXML
    private TableColumn nombreColumn;

    /*private ObservableList<Alumnos> alumnos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.idcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.apellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        this.edadColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));
        this.gradoColumn.setCellValueFactory(new PropertyValueFactory<>("grado"));
    }*/

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

            mostrarTable.getItems().add(alumno);
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

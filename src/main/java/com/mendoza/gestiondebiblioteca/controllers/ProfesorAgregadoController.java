package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
import com.mendoza.gestiondebiblioteca.models.Persona;
import com.mendoza.gestiondebiblioteca.models.Profesores;
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

public class ProfesorAgregadoController implements Initializable {

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
    private Label nombreLabel;

    @FXML
    private Label apellidosLabel;

    @FXML
    private Label edadLabel;

    @FXML
    private Label areaLabel;

    @FXML
    private Button salirBtn;

    @FXML
    private Button verBtn;

    @FXML
    private Button volverBtn;

    @FXML
    private TableColumn apellidoColumn;

    @FXML
    private TableColumn edadColumn;

    @FXML
    private TableColumn areaColumn;

    @FXML
    private TableColumn idcolumn;

    @FXML
    private TableView<Persona> mostrarTable;

    @FXML
    private TableColumn nombreColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.idcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.apellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        this.edadColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));
        this.areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        ObservableList<Persona> list = FXCollections.observableArrayList(Application.getListaProfesores());
        mostrarTable.setItems(list);
    }

    @FXML
    void OnMouseClickedVerBtn(MouseEvent event) {
        nombreTxt.setVisible(false);
        nombreLabel.setVisible(false);
        apellidosTxt.setVisible(false);
        apellidosLabel.setVisible(false);
        edadTxt.setVisible(false);
        edadLabel.setVisible(false);
        apellidosLabel.setVisible(false);
        areaTxt.setVisible(false);
        areaLabel.setVisible(false);
        salirBtn.setVisible(false);
        agregarBtn.setVisible(false);

        mostrarTable.setVisible(true);
        volverBtn.setVisible(true);
    }

    @FXML
    void OnMouseClickedVolverBtn(MouseEvent event) {
        nombreTxt.setVisible(true);
        nombreLabel.setVisible(true);
        apellidosTxt.setVisible(true);
        apellidosLabel.setVisible(true);
        edadTxt.setVisible(true);
        edadLabel.setVisible(true);
        apellidosLabel.setVisible(true);
        areaTxt.setVisible(true);
        areaLabel.setVisible(true);
        salirBtn.setVisible(true);
        agregarBtn.setVisible(true);

        mostrarTable.setVisible(false);
        volverBtn.setVisible(false);
    }

    @FXML
    void OnClickedAgregarBtn(MouseEvent event) {
        ArrayList<Profesores> profesores = Application.getPersona().getListaProfesores();

        String nombre = nombreTxt.getText();
        String apellidos = apellidosTxt.getText();
        String edad = edadTxt.getText();
        String area = areaTxt.getText();

        Profesores profesor = new Profesores(nombre, apellidos, edad, area);

        if (!Application.getPersona().getListaProfesores().contains(profesor)/*profesores.add(profesor)*/) {
            Application.getPersona().getListaProfesores().add(profesor);

            mostrarAlerta("Éxito", "Se ha agregado un nuevo usuario.");

            System.out.println("Se ha agregado un nuevo usuario:");
            System.out.println("ID: " + profesor.getId());
            System.out.println("Nombre: " + profesor.getNombre());
            System.out.println("Apellidos: " + profesor.getApellidos());
            System.out.println("Edad: " + profesor.getEdad());
            System.out.println("Área: "+profesor.getArea());

            mostrarTable.getItems().add(profesor);
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
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}

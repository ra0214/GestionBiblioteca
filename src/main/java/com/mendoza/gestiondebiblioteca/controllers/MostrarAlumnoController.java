package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MostrarAlumnoController implements Initializable {

    @FXML
    private TableColumn<Alumnos, Integer> apellidoColumn;

    @FXML
    private TableColumn<Alumnos, String> edadColumn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TableColumn<Alumnos, String> gradoColumn;

    @FXML
    private TableColumn<Alumnos, Integer> idcolumn;

    @FXML
    private TableView<Alumnos> mostrarTable;

    @FXML
    private TableColumn<Alumnos, String> nombreColumn;

    @FXML
    private Button salirBtn;

    private ObservableList<Alumnos> alumnosList = FXCollections.observableArrayList();

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mostrarUsuarios-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Mostrar Usuarios");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alumnosList = FXCollections.observableArrayList();

        this.idcolumn.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreColumn.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.apellidoColumn.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.edadColumn.setCellValueFactory(new PropertyValueFactory("edad"));
        this.gradoColumn.setCellValueFactory(new PropertyValueFactory("grado"));

        mostrarTable.setItems(alumnosList);
    }

    public void agregarAlumno(Alumnos alumno) {
        alumnosList.add(alumno);
    }
}

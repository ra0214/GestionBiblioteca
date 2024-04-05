package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
import com.mendoza.gestiondebiblioteca.models.Persona;
import javafx.beans.DefaultProperty;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MostrarUsuariosController implements Initializable {

    @FXML
    private TableColumn<Alumnos, String> apellidoColumn;

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
    ObservableList<Alumnos> list = FXCollections.observableArrayList(
            new Alumnos("Keren","Rojas López", "18","Segundo")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcolumn.setCellValueFactory(new PropertyValueFactory<Alumnos, Integer>("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("nombre"));
        apellidoColumn.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("apellido"));
        edadColumn.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("edad"));
        gradoColumn.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("grado"));

        mostrarTable.setItems(list);
    }

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menuSuper-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Menú De Super Administrador");
        stage.show();
    }
}

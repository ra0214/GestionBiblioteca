package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Libro;
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

public class MostrarLibrosController implements Initializable {

    @FXML
    private TableColumn<Libro, String> autorColumn;

    @FXML
    private TableColumn<Libro, String> cantidadColumn;

    @FXML
    private TableColumn<Libro, String> editorialColumn;

    @FXML
    private TableColumn<Libro, String> fechaColumn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TableColumn<Libro, String> idColumn;

    @FXML
    private Button salirBtn;

    @FXML
    private TableView<Libro> tabla;

    @FXML
    private TableColumn<Libro, String> tituloColumn;

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menuAdmin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Menú de Administrador");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        this.autorColumn.setCellValueFactory(new PropertyValueFactory<>("autor"));
        this.editorialColumn.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        this.cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDisponible"));
        this.fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));

        this.tabla.setItems(Application.getLibros());
    }
}

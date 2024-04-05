package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MostrarProfesorController {

    @FXML
    private TableColumn<?, ?> apellidoColumn;

    @FXML
    private TableColumn<?, ?> edadColumn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TableColumn<?, ?> areaColumn;

    @FXML
    private TableColumn<?, ?> idcolumn;

    @FXML
    private TableView<?> mostrarTable;

    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private Button salirBtn;

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

}

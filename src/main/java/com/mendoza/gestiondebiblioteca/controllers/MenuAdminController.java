package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAdminController {

    @FXML
    private Button buscarBtn;

    @FXML
    private Button buscarusBtn;

    @FXML
    private Button mostrarBtn;

    @FXML
    private Button mostrarusuBtn;

    @FXML
    private Button prestamoBtn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Gestión De Biblioteca");
        stage.show();
    }

    @FXML
    void onClickedBuscarBtn(MouseEvent event) {
    }

    @FXML
    void onClickedBuscarusBtn(MouseEvent event) {
    }

    @FXML
    void onClickedMostrarBtn(MouseEvent event) {
    }

    @FXML
    void onClickedMostrarusuBtn(MouseEvent event) {
    }

    @FXML
    void onClickedPrestamoBtn(MouseEvent event) {
    }
}


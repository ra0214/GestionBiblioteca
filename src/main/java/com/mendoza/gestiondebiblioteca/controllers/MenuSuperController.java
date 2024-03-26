package com.mendoza.gestiondebiblioteca.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import com.mendoza.gestiondebiblioteca.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuSuperController {

    @FXML
    private Button actualizarBtn;

    @FXML
    private Button actualizarusuBtn;

    @FXML
    private Button agregarBtn;

    @FXML
    private Button agregarusBtn;

    @FXML
    private Button buscarBtn;

    @FXML
    private Button eliminarBtn;

    @FXML
    private Button eliminarusBtn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Button mostrarBtn;

    @FXML
    private Button mostrarusuBtn;

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
    void onClickedActualizarBtn(MouseEvent event) {
    }

    @FXML
    void onClickedActualizarusuBtn(MouseEvent event) {
    }

    @FXML
    void onClickedAgregarBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("agregarLibro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Agregar Libro");
        stage.show();
    }

    @FXML
    void onClickedAgregarusBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("agregarUsuario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Agregar Usuario");
        stage.show();
    }

    @FXML
    void onClickedBuscarBtn(MouseEvent event) {
    }

    @FXML
    void onClickedBuscarusBtn(MouseEvent event) {
    }

    @FXML
    void onClickedEliminarBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("eliminarLbro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Eliminar Libro");
        stage.show();
    }

    @FXML
    void onClickedEliminarusBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("eliminarUsuario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Eliminar Usuario");
        stage.show();
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



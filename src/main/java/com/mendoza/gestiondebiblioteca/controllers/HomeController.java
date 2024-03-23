package com.mendoza.gestiondebiblioteca.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button adminBtn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Button salirBtn;

    @FXML
    private Button superBtn;

    @FXML
    void onClickedAdminBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("admin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Inicio de sesión (Administrador)");
        stage.show();
    }

    @FXML
    void onClickedSalirBtn(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    void onClickedSuperBtn(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("super-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Inicio de sesión (Super Administrador)");
        stage.show();
    }

}

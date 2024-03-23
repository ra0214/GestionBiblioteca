package com.mendoza.gestiondebiblioteca.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Usuarios;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SuperController {
    @FXML
    private Label contLabel;

    @FXML
    private PasswordField contraseña;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Button iniciarBtn;

    @FXML
    private Button salirBtn;

    @FXML
    private Label usuLabel;

    @FXML
    private TextField usuario;

    @FXML
    void onClickedIniciarBtn(MouseEvent event) throws IOException {
        String usuarioText = usuario.getText();
        String contraseñaText = contraseña.getText();

        if (usuarioText.equals("superAdministrador")) {
            if (contraseñaText.equals("2305")) {
                Stage currentStage = (Stage) fondo.getScene().getWindow();
                currentStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menuSuper-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Menú De Super Administrador");
                stage.show();
            } else {
                mostrarAlerta("Error de contraseña", "La contraseña es incorrecta, intentalo nuevamente.");
            }
        } else {
            mostrarAlerta("Error de usuario", "El usuario es incorrecto, intentalo nuevamente.");
        }
    }

    @FXML
    void onClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Gestión De Biblioteca");
        stage.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}


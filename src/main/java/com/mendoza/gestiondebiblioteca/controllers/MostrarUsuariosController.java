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

public class MostrarUsuariosController {

    @FXML
    private Button alumnoBtn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Button profesorBtn;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menuSuper-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Menú de Super Administrador");
        stage.show();
    }

    @FXML
    void onClickAlumnoBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mostrarAlumno-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Mostrar Lista de Alumnos");
        stage.show();
    }

    @FXML
    void onClickProfesorBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mostrarProfesor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Mostrar Lista de Profesores");
        stage.show();
    }

}

package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfesorEliminadoController {

    @FXML
    private TextField apellidosTxt;

    @FXML
    private Button eliminarBtn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TextField nombreTxt;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedEliminarBtn(MouseEvent event) {

    }

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("eliminarUsuario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Eliminar Usuario");
        stage.show();
    }

}

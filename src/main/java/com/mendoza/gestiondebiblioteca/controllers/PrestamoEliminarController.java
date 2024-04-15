package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Alumnos;
import com.mendoza.gestiondebiblioteca.models.Prestamos;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PrestamoEliminarController {

    @FXML
    private Button eliminarBtn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TextField libroTxt;

    @FXML
    private TextField nombreTxt;

    @FXML
    private Button salirBtn;

    @FXML
    void OnClickedEliminarBtn(MouseEvent event) {
        String usuario = nombreTxt.getText();
        String libro = libroTxt.getText();

        //ArrayList<Prestamos> listaPrestamos = Application.getPrestamo().getListaPrestamos();
        ObservableList<Prestamos> listaPrestamos = Application.getPrestamos();

        Prestamos prestamoEliminar = null;
        for (Prestamos prestamo : listaPrestamos) {
            if (prestamo.getPersona().equals(usuario) && prestamo.getLibro().equals(libro)) {
                prestamoEliminar = prestamo;
                break;
            }
        }

        if (prestamoEliminar != null) {
            listaPrestamos.remove(prestamoEliminar);
            mostrarAlerta("Éxito", "Se ha eliminado el préstamo correctamente.");
        } else {
            mostrarAlerta("Error", "No se encontró ningún préstamo con ese usuario y libro.");
        }
        limpiarCampos();
    }

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

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        nombreTxt.clear();
        libroTxt.clear();
    }
}

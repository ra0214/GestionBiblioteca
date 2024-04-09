package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Prestamos;
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

public class ListasPrestamosController implements Initializable {

    @FXML
    private TableColumn<Prestamos, String> fechafinColumn;

    @FXML
    private TableColumn<Prestamos, String> fechainColumn;

    @FXML
    private AnchorPane fondo;

    @FXML
    private TableColumn<Prestamos, String> nombreColumn;

    @FXML
    private Button salirBtn;

    @FXML
    private TableView<Prestamos> tabla;

    @FXML
    private TableColumn<Prestamos, String> tituloColumn;

    @FXML
    void OnClickedSalirBtn(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) fondo.getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menuAdmin-view.fxml"));
        Scene scene = new Scene(fxmlLoader. load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Menú De Administrador");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.nombreColumn.setCellValueFactory(new PropertyValueFactory<>("persona"));
        this.tituloColumn.setCellValueFactory(new PropertyValueFactory<>("libro"));
        this.fechainColumn.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
        this.fechafinColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));

        this.tabla.setItems(Application.getPrestamos());
    }
}

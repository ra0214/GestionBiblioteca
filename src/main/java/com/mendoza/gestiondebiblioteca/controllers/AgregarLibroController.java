package com.mendoza.gestiondebiblioteca.controllers;

import com.mendoza.gestiondebiblioteca.Application;
import com.mendoza.gestiondebiblioteca.models.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgregarLibroController implements Initializable {

    @FXML
    private Button agregarBtn;

    @FXML
    private TextField nomlibroTxt;

    @FXML
    private TextField autorTxt;

    @FXML
    private TextField cantidadTxt;

    @FXML
    private TextField editorialTxt;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField fechaTxt;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Label autor;

    @FXML
    private Label cant;

    @FXML
    private Label edit;

    @FXML
    private Label fech;

    @FXML
    private Label fecha;

    @FXML
    private Label id;

    @FXML
    private Label name;

    @FXML
    private Button salirBtn;

    @FXML
    private Button verBtn;

    @FXML
    private Button volverBtn;

    @FXML
    private TableColumn autorColumn;

    @FXML
    private TableColumn cantidadColumn;

    @FXML
    private TableColumn editorialColumn;

    @FXML
    private TableColumn fechaColumn;

    @FXML
    private TableColumn idColumn;

    @FXML
    private TableView<Libro> tabla;

    @FXML
    private TableColumn tituloColumn;



    //private ObservableList<Libro> libros;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //libros = FXCollections.observableArrayList();

        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        this.autorColumn.setCellValueFactory(new PropertyValueFactory<>("autor"));
        this.editorialColumn.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        this.cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDisponible"));
        this.fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));
        ObservableList<Libro> lista = FXCollections.observableArrayList(Application.getLibros());
        tabla.setItems(lista);
    }


    @FXML
    void OnClickedAgregarBtn(MouseEvent event) {
        //ArrayList<Libro> libros = Application.getLibro().getListaLibros();
        String id = this.idTxt.getText();
        String titulo = this.nomlibroTxt.getText();
        String autor = this.autorTxt.getText();
        String editorial = this.editorialTxt.getText();
        String cant = this.cantidadTxt.getText();
        String fech = this.fechaTxt.getText();


        Libro libro = new Libro(id,titulo,autor,editorial, cant, fech);

        if (!Application.getLibros().contains(libro)) {
            Application.getLibros().add(libro);

            this.tabla.setItems(Application.getLibros());
            mostrarAlerta("Éxito", "Se ha agregado un nuevo libro.");

            System.out.println("Se ha agregado un nuevo libro:");
            System.out.println("ID: "+libro.getId());
            System.out.println("Título: "+libro.getTitulo());
            System.out.println("Autor: "+libro.getAutor());
            System.out.println("Editorial: "+libro.getEditorial());
            System.out.println("Cantidad: "+libro.getCantidadDisponible());
            System.out.println("Fecha: "+libro.getFechaPublicacion());
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
        stage.setTitle("Menú De Super Administrador");
        stage.show();
    }

    @FXML
    void OnMouseClickedVerBtn(MouseEvent event) {
        id.setVisible(false);
        idTxt.setVisible(false);
        name.setVisible(false);
        nomlibroTxt.setVisible(false);
        autorTxt.setVisible(false);
        autor.setVisible(false);
        editorialTxt.setVisible(false);
        edit.setVisible(false);
        cant.setVisible(false);
        cantidadTxt.setVisible(false);
        fech.setVisible(false);
        fecha.setVisible(false);
        fechaTxt.setVisible(false);
        agregarBtn.setVisible(false);
        salirBtn.setVisible(false);

        tabla.setVisible(true);
        volverBtn.setVisible(true);
    }

    @FXML
    void OnMouseClickedVolverBtn(MouseEvent event) {
        id.setVisible(true);
        idTxt.setVisible(true);
        name.setVisible(true);
        nomlibroTxt.setVisible(true);
        autorTxt.setVisible(true);
        autor.setVisible(true);
        editorialTxt.setVisible(true);
        edit.setVisible(true);
        cant.setVisible(true);
        cantidadTxt.setVisible(true);
        fech.setVisible(true);
        fecha.setVisible(true);
        fechaTxt.setVisible(true);
        agregarBtn.setVisible(true);
        salirBtn.setVisible(true);

        tabla.setVisible(false);
        volverBtn.setVisible(false);
    }

    private void limpiarCampos() {
        nomlibroTxt.clear();
        autorTxt.clear();
        editorialTxt.clear();
        idTxt.clear();
        cantidadTxt.clear();
        fechaTxt.clear();
    }



    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
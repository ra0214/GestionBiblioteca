package com.mendoza.gestiondebiblioteca;

import com.mendoza.gestiondebiblioteca.models.Biblioteca;
import com.mendoza.gestiondebiblioteca.models.Persona;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private static Biblioteca usuarios = new Biblioteca();

    private static Persona persona = new Persona();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Gestión De Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    public static Biblioteca getUsuario() {
        return usuarios;
    }

    public static Persona getPersona() {
        return persona;
    }

    public static void main(String[] args) {
        launch();
    }
}
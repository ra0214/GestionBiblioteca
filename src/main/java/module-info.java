module com.mendoza.gestiondebiblioteca {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.mendoza.gestiondebiblioteca.models to javafx.base;
    opens com.mendoza.gestiondebiblioteca to javafx.fxml;
    exports com.mendoza.gestiondebiblioteca;
    exports com.mendoza.gestiondebiblioteca.controllers;
    opens com.mendoza.gestiondebiblioteca.controllers to javafx.fxml;
}
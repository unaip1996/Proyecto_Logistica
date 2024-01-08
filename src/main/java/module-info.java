module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires org.hibernate.orm.core;
    requires jdk.jfr;
    requires jakarta.persistence;
    requires java.persistence;
    requires java.naming;
    requires java.desktop;

    opens app to javafx.fxml;
    exports app;
    exports Entities.Usuarios;
    exports app.ViewControllers.Admin.Usuario;
    exports app.ViewControllers;
    exports app.ViewControllers.Cliente;
}
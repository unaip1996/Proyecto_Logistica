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
    exports Entities.operaciones;
    exports app.ViewControllers.Admin;
    exports app.ViewControllers.Admin.Usuario;
    exports app.ViewControllers.Admin.Direccion;
    exports app.ViewControllers;
    exports app.ViewControllers.Cliente;
}
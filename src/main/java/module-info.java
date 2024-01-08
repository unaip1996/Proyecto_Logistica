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

    opens app to javafx.fxml;
    exports app;
    exports Entities.Usuarios;
    exports app.ViewControllers.Admin;
    exports app.ViewControllers.Admin.Usuario;
}
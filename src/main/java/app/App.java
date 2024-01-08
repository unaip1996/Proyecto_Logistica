package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static final String APP_NAME = "Gestión Logística";
    protected static DB db;

    public static void main(String[] args) {
        db = new DB();
        db.setUp();

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(APP_NAME);
        stage.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("/Usuario/Log_in.fxml"))));
        stage.show();
    }
}

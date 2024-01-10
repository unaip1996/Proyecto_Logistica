package app;

import Util.DB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static DB db;
    public static final String APP_NAME = "Gestión Logística";

    @Override
    public void start(Stage stage) throws Exception {
        db = new DB();
        db.setUp();

        stage.setTitle(APP_NAME);
        stage.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("/Log_in.fxml"))));
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}

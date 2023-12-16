package src.app;

public class App {
    private static DB db;

    public static void main(String[] args) {
        db = new DB();
        db.setUp();
    }
}

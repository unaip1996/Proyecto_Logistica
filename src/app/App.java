package app;

public class App {
    protected static DB db;

    public static void main(String[] args) {
        db = new DB();
        db.setUp();
    }
}

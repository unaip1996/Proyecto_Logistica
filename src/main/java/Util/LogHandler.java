package Util;

import app.App;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogHandler {
    public static void log(Level level, String message) {
        Logger logger = Logger.getLogger(App.class.getName());

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
            FileHandler fh = new FileHandler("./logs/"+format.format(new Date()) + ".log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.log(level, message);
        }catch (IOException e) {

        }
    }
}

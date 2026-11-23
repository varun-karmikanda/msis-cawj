package college;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppLogger {
    public static final Logger logger = Logger.getLogger("Library");

    static {
        try{
            FileHandler fh = new FileHandler("src/college/college.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            System.out.println("Error handling log file: " + e);
        }
    }

    public static void info(String msg){
        logger.info(msg);
    }

    public static void error(String msg){
        logger.severe(msg);
    }
}

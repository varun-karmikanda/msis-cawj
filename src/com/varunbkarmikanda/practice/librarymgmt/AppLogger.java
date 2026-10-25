package com.varunbkarmikanda.practice.librarymgmt;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class AppLogger {
    public static final Logger logger = Logger.getLogger("Library");

    static {
        try{
            FileHandler fh = new FileHandler("src/com/varunbkarmikanda/practice/librarymgmt/library.log", true);
            fh.setFormatter(new SimpleFormatter(){
                @Override
                public String format(LogRecord r){
                    return String.format("%1$tF %1$tT | %2$-7s | %3$s%n",
                            new Date(r.getMillis()), r.getLevel(), r.getMessage());
                }
            });

            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.out.println("Could not set up log file: " + e.getMessage());
        }
    }

    public static void info(String msg) { logger.info(msg); }

    public static void error(String msg) { logger.severe(msg); }
}

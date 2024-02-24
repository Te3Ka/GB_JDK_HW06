package org.example;

import java.io.*;

public class Logger {
    private static final String FILE_PATH = "src\\main\\java\\org\\example\\log_file.txt";

    public static void logFile(String messages) {
        File file = new File(FILE_PATH);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(messages);
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

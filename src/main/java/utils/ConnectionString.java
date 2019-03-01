package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* Written to read from a "Hidden" passswords file
* This prevents us from exposing passwords on github.
* (Irrelevant for project)
* */
public class ConnectionString {
    private String[] data;
    private static final int dataLength = 2;

    public ConnectionString(String path) {
        parseFile(path);
    }

    private void parseFile(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            data = new String[dataLength];

            String line;
            int lineCount = 0;
            while ((line = scanner.nextLine()) != null) {
                data[lineCount++] = line;

                if (lineCount >= dataLength) break;
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("Could not find file: " + path);
        }
    }

    public String getUsername() { return data[0]; }
    public String getPassword() { return data[1]; }
}

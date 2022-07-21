package org.example.io.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.example.io.TextInputService;

public class SampleFileTextInputService implements TextInputService {
    private static final Path FILE_NAME = Path.of("C:\\Users\\abdel\\OneDrive\\Desktop\\Java-Course-June2022\\Projects\\streamchallengepractice\\untitled\\book.txt");
    @Override
    public String getText() {
        String content = null;
       try {  content = Files.readString(FILE_NAME);
            
    } catch(Exception E) {
        E.printStackTrace();
        // System.out.println("Invalid entry");
    }
    return content;
}
}

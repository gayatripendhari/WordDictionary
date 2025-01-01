package com.jspiders.dictionaryapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileHandler {

    private static final String FILE_NAME = "dictionary.txt";

    public static void saveDictionary(Map<String, String> dictionary) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving dictionary: " + e.getMessage());
        }
    }

    public static void loadDictionary(Map<String, String> dictionary) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    dictionary.put(parts[0], parts[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found. A new one will be created.");
        } catch (IOException e) {
            System.err.println("Error loading dictionary: " + e.getMessage());
        }
    }
}

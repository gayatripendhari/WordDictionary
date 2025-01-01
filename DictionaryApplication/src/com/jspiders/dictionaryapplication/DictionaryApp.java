package com.jspiders.dictionaryapplication;

import java.util.Map;
import java.util.Scanner;

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        FileHandler.loadDictionary(dictionary.getAllWords());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Dictionary Application ---");
            System.out.println("1. Search Word");
            System.out.println("2. Add Word");
            System.out.println("3. Update Word");
            System.out.println("4. Delete Word");
            System.out.println("5. View All Words");
            System.out.println("6. Save & Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter word to search: ");
                    String searchWord = scanner.nextLine();
                    String meaning = dictionary.getMeaning(searchWord);
                    if (meaning != null) {
                        System.out.println(searchWord + ": " + meaning);
                    } else {
                        System.out.println("Word not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter new word: ");
                    String newWord = scanner.nextLine();
                    if (dictionary.containsWord(newWord)) {
                        System.out.println("Word already exists.");
                    } else {
                        System.out.print("Enter its meaning: ");
                        String newMeaning = scanner.nextLine();
                        dictionary.addWord(newWord, newMeaning);
                        System.out.println("Word added successfully.");
                    }
                    break;

                case 3:
                    System.out.print("Enter word to update: ");
                    String updateWord = scanner.nextLine();
                    if (dictionary.containsWord(updateWord)) {
                        System.out.print("Enter new meaning: ");
                        String updatedMeaning = scanner.nextLine();
                        dictionary.updateWord(updateWord, updatedMeaning);
                        System.out.println("Word updated successfully.");
                    } else {
                        System.out.println("Word not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter word to delete: ");
                    String deleteWord = scanner.nextLine();
                    dictionary.deleteWord(deleteWord);
                    System.out.println("Word deleted successfully.");
                    break;

                case 5:
                    System.out.println("All Words:");
                    for (Map.Entry<String, String> entry : dictionary.getAllWords().entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 6:
                    FileHandler.saveDictionary(dictionary.getAllWords());
                    System.out.println("Dictionary saved. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

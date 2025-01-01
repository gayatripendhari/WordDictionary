package com.jspiders.dictionaryapplication;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private Map<String, String> words;

    public Dictionary() {
        words = new HashMap<>();
    }

    public String getMeaning(String word) {
        return words.get(word);
    }

    public void addWord(String word, String meaning) {
        words.put(word, meaning);
    }

    public void updateWord(String word, String newMeaning) {
        if (words.containsKey(word)) {
            words.put(word, newMeaning);
        } else {
            System.out.println("Word not found!");
        }
    }

    public void deleteWord(String word) {
        words.remove(word);
    }

    public Map<String, String> getAllWords() {
        return words;
    }

    public boolean containsWord(String word) {
        return words.containsKey(word);
    }
}

package com.wordgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private final List<String> words = new ArrayList<>();
    private final Random random = new Random();

    public Dictionary(String... initialWords) {
        for (String w : initialWords) {
            addWord(w);
        }
    }

    public void addWord(String word) {
        if (word == null || !word.matches("[a-zA-Z]{4}")) {
            throw new IllegalArgumentException(
                "Words must be exactly 4 letters, got: \"" + word + "\"");
        }
        String normalized = word.toLowerCase();
        if (!words.contains(normalized)) {
            words.add(normalized);
        }
    }

    public boolean contains(String word) {
        if (word == null) throw new IllegalArgumentException("Word must not be null");
        return words.contains(word.toLowerCase());
    }

    public String getRandomWord() {
        if (words.isEmpty()) throw new IllegalStateException("Dictionary is empty");
        return words.get(random.nextInt(words.size()));
    }

    public int size() {
        return words.size();
    }
}

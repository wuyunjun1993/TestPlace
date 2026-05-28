package com.wordgame;

public class WordGuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Word Guessing Game!");

        // Test Dictionary
        Dictionary dict = new Dictionary("cake", "bike", "word", "game", "test");
        System.out.println("Dictionary loaded with " + dict.size() + " words");
        System.out.println("Secret word: " + dict.getRandomWord());
        System.out.println("Contains 'cake': " + dict.contains("cake"));
        System.out.println("Contains 'BIKE': " + dict.contains("BIKE"));
        System.out.println("Contains 'xyz': " + dict.contains("xyz"));
    }
}

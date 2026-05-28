package com.wordgame;

import org.junit.Test;
import static org.junit.Assert.*;

public class DictionaryTest {

    // --- Constructor ---

    @Test
    public void emptyConstructorCreatesEmptyDictionary() {
        assertEquals(0, new Dictionary().size());
    }

    @Test
    public void constructorLoadsInitialWords() {
        assertEquals(2, new Dictionary("cake", "bike").size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorRejectsInvalidWord() {
        new Dictionary("cat");
    }

    // --- addWord happy path ---

    @Test
    public void addWordIncreasesSize() {
        Dictionary dict = new Dictionary();
        dict.addWord("word");
        assertEquals(1, dict.size());
    }

    @Test
    public void addWordNormalizesToLowercase() {
        Dictionary dict = new Dictionary();
        dict.addWord("CAKE");
        assertTrue(dict.contains("cake"));
    }

    @Test
    public void addWordIgnoresDuplicates() {
        Dictionary dict = new Dictionary("cake");
        dict.addWord("cake");
        dict.addWord("CAKE");
        assertEquals(1, dict.size());
    }

    // --- addWord error cases ---

    @Test(expected = IllegalArgumentException.class)
    public void addWordRejectsNull() {
        new Dictionary().addWord(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWordRejectsTooShort() {
        new Dictionary().addWord("cat");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWordRejectsTooLong() {
        new Dictionary().addWord("cakes");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWordRejectsNonAlpha() {
        new Dictionary().addWord("1234");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWordRejectsWordWithSpace() {
        new Dictionary().addWord("c at");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWordRejectsWordWithSpecialChar() {
        new Dictionary().addWord("ab!c");
    }

    // --- contains ---

    @Test
    public void containsReturnsTrueForExistingWord() {
        assertTrue(new Dictionary("cake").contains("cake"));
    }

    @Test
    public void containsReturnsFalseForMissingWord() {
        assertFalse(new Dictionary("cake").contains("bike"));
    }

    @Test
    public void containsIsCaseInsensitive() {
        Dictionary dict = new Dictionary("cake");
        assertTrue(dict.contains("CAKE"));
        assertTrue(dict.contains("Cake"));
        assertTrue(dict.contains("cAkE"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void containsRejectsNull() {
        new Dictionary("cake").contains(null);
    }

    // --- getRandomWord ---

    @Test(expected = IllegalStateException.class)
    public void getRandomWordThrowsOnEmptyDictionary() {
        new Dictionary().getRandomWord();
    }

    @Test
    public void getRandomWordReturnedWordIsInDictionary() {
        Dictionary dict = new Dictionary("cake", "bike", "word");
        assertTrue(dict.contains(dict.getRandomWord()));
    }

    @Test
    public void getRandomWordWithSingleWordAlwaysReturnsThatWord() {
        Dictionary dict = new Dictionary("cake");
        assertEquals("cake", dict.getRandomWord());
    }
}

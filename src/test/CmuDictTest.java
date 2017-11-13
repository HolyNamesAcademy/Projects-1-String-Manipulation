package test;

import org.junit.Test;

import static org.junit.Assert.*;

public class CmuDictTest {

    /* Check that the method returns true for input that is a valid dictionary line */
    @Test
    public void testIsWordEntry_ValidEntry() {
        // TODO: implement this
    }

    /* Check that the method returns false for input that isn't a valid dictionary line */
    @Test
    public void testIsWordEntry_InvalidEntry() {
        // TODO: implement this
    }

    /* Check that we correctly extract a word from a dictionary line */
    @Test
    public void testGetWord_ValidLine() {
        // TODO: implement this
    }

    /* Check that when a line contains a word with an alternate pronunciation, (e.g. it ends with "(1)"), we only
       extract the word. */
    @Test
    public void testGetWord_AlternatePronunciation() {
        // TODO: implement this
    }

    /* Check that we don't extract a word from an invalid dictionary line */
    @Test
    public void testGetWord_InvalidLine() {
        // TODO: extra credit
    }

    /* Check that we correctly extract the phonemes from a dictionary line */
    @Test
    public void testGetPhonemes_ValidLine() {
        // TODO: implement this
    }

    /* Check that we don't extract the phonemes from an invalid dictionary line */
    @Test
    public void testGetPhonemes_InvalidLine() {
        // TODO: extra credit
    }

    /* Check that we correctly find the line for a word that exists in the dictionary */
    @Test
    public void testGetDictLineForWord_WordInDictionary() {
        // TODO: implement this
    }

    /* Check that we don't find a line for a word that isn't in the dictionary */
    @Test
    public void testGetDictLineForWord_WordNotInDictionary() {
        // TODO: implement this
    }
}

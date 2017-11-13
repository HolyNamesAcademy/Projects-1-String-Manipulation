package rhymingwords;

import java.util.ArrayList;

/** Helper class for finding rhyming words in CmuDict. */
public class WordRhymer {
    // Keep a CmuDict object as a member variable for use in WordRhymer's methods.
    private CmuDict cmuDict = new CmuDict();

    /**
     * Generate a list of words that rhyme with wordToRhyme
     * @param wordToRhyme the word we want to find rhyming words for
     * @param numRhymingWords the maximum number of rhyming words we want to find
     * @return A list containing words that rhyme with wordToRhyme. It should have at most numRhymingWords words in it.
     */
    public ArrayList<String> findRhymingWords(String wordToRhyme, int numRhymingWords) {
        // TODO: implement this
        return null;
    }

    /**
     * Determine whether two sets of phonemes have the same final 3 phonemes.
     * @param word1Phonemes the phonemes for the first word
     * @param word2Phonemes the phonemes for the second word
     * @return whether the two sets of phonemes match at their last 3 phonemes.
     */
    public static boolean finalPhonemesMatch(String[] word1Phonemes, String[] word2Phonemes) {
        // TODO: implement this
        return false;
    }
}

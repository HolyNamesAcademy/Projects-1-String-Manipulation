import java.util.List;

/**
 * Class that provides users with words that are eligible to be rhymes, and also checks whether words rhyme.
 * Rhymes are based on the matching of the words final phonemes.
 */
public class WordRhymer {

    private PhonemeDictionary phonemeDictionary = new PhonemeDictionary();

    /**
     * Returns the list of all words that are available for rhyming.
     *
     * @return the list of all possible rhymes
     */
    public List<String> getAllPossibleRhymes() {
        return phonemeDictionary.getEntries();
    }

    /**
     * Determines whether two English words rhyme by comparing their final phonemes from the dictionary.
     * Two words will be considered rhymes if their final three phonemes match. If either word has fewer than three
     * phonemes, all phonemes for the word with fewer than three phonemes must match at the end of the other word.
     *
     * @param word          the English word to be rhymed with
     * @param possibleRhyme the English word being considered a rhyme
     * @return true if possibleRhyme rhymes with word per the phoneme matching rules
     */
    //TODO - implement me!
    // Look up phonemes with phonemeDictionary.getPhonemes(word) and getPhonemes(possibleRhyme).
    // Empty phoneme list → false; same word (equalsIgnoreCase) → false; then compare tails.
    public boolean checkForRhyme(String word, String possibleRhyme) {
        return false;
    }
}

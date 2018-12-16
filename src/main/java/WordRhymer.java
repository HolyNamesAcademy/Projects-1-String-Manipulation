import java.util.List;

/**
 * Class that provides users with words that are eligible to be rhymes, and also checks whether words rhyme.
 * Rhymes are based on the matching of the words final phonemes.
 */
public class WordRhymer {

    private PhonemeDictionary phonemeDictionary = PhonemeDictionary.getDictionary();

    /**
     * Returns the list of all words that are available for rhyming.
     * @return the list of all possible rhymes
     */
    public List<String> getAllPossibleRhymes() {
        return phonemeDictionary.getEntries();
    }

    /**
     * Determine whether two words rhyme. A rhyme is determined by matching the final phonemes of the words.
     * Two words will be considered rhymes if their final three phonemes match. If either word has fewer than three
     * phonemes, all phonemes for the word with fewer than three phonemes must match the the end of the other word.
     * @param word the phonemes for the word to be rhymed with
     * @param possibleRhyme the phonemes for the word being considered a rhyme
     * @return true if possibleRhyme is a rhyme with word as determined by the phoneme matching rule noted above
     */
    public boolean checkForRhyme(String word, String possibleRhyme) {

        List<String> wordPhonemes = phonemeDictionary.getPhonemes(word);
        List<String> possibleRhymePhonemes = phonemeDictionary.getPhonemes(possibleRhyme);

        int size1 = wordPhonemes.size();
        int size2 = possibleRhymePhonemes.size();

        if(size1 == 0 || size2 == 0) {
            return false;
        }

        int maxComps = Math.min(3, size1);

        while(size1 > 0 && size2 > 0 && maxComps > 0){
            if(!wordPhonemes.get(size1 - 1).equalsIgnoreCase(possibleRhymePhonemes.get(size2 - 1)))
                return false;
            size1--;
            size2--;
            maxComps--;
        }

        return true;
    }
}

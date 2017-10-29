package solution;

import java.util.ArrayList;

/**
 * Util class for finding rhyming words in CmuDict.
 */
public class WordRhymer {
    private CmuDict cmuDict;

    public WordRhymer() {
        this.cmuDict = new CmuDict();
        System.out.println(cmuDict.getDictLines().size());
    }

    /**
     * Generate a list of words that rhyme with wordToRhyme
     * @param wordToRhyme the word we want to find rhyming words for
     * @param numRhymingWords the maximum number of rhyming words we want to find
     * @return A list containing words that rhyme with wordToRhyme. It should have at most numRhymingWords words in it.
     */
    public ArrayList<String> findRhymingWords(String wordToRhyme, int numRhymingWords) {
        ArrayList<String> rhymingWords = new ArrayList();
        ArrayList<String> lines = cmuDict.getDictLines();
        int numRhymingWordsFound = 0;
        String wordLine = cmuDict.getDictLineForWord(wordToRhyme);
        if (wordLine.equals("")) {
            return rhymingWords;
        }
        for (int i = 0; i < lines.size(); i++) {
            if (numRhymingWordsFound == numRhymingWords) {
                break;
            }
            String currentLine = lines.get(i);
            String currentWord = CmuDict.getWord(currentLine);
            if (!wordToRhyme.equalsIgnoreCase(currentWord)) {
                String[] wordPhonemes = CmuDict.getPhonemes(wordLine);
                String[] currentWordPhonemes = CmuDict.getPhonemes(currentLine);
                if (finalPhonemesMatch(wordPhonemes, currentWordPhonemes)) {
                    rhymingWords.add(currentWord);
                    numRhymingWordsFound++;
                }
            }
        }
        return rhymingWords;
    }

    /**
     * Determine whether two sets of phonemes have the same final few phonemes.
     * @param word1Phonemes the phonemes for the first word
     * @param word2Phonemes the phonemes for the second word
     * @return whether the two sets of phonemes match at their last few (5).
     */
    public static boolean finalPhonemesMatch(String[] word1Phonemes, String[] word2Phonemes) {
        int len1 = word1Phonemes.length;
        int len2 = word2Phonemes.length;
        int minPhonemes = Math.min(len1, len2);
        int numPhonemesToCompare = Math.min(3, minPhonemes);
        for (int i = 0; i < numPhonemesToCompare; i++) {
            String phoneme1 = word1Phonemes[len1 - 1 - i];
            String phoneme2 = word2Phonemes[len2 - 1 - i];
            if (!phoneme1.equals(phoneme2)) {
                return false;
            }
        }
        return true;
    }
}

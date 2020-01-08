import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods that are helpful when working with the CMU Phoneme Dictionary
 */
public class PhonemeDictionaryUtilities {
    /**
     * Checks that the provided line is an entry in the file that contains a word and phonemes, and that it is not a
     * line containing comments.
     *
     * @param line - a line from the dictionary being parsed
     * @return true if the given line contains a word entry, false otherwise
     */
    //TODO - implement me!
    public static boolean isPhonemeEntry(String line) {
        return false;
    }

    /**
     * Get the word component of a dictionary line. Lines are of the format: WORD PH1 PH2 PH3
     *
     * @param line - the dictionary line we want to extract the word from
     * @return the word part of line
     */
    //TODO - implement me!
    public static String getWordFromLine(String line) {
        return "";
    }

    /**
     * Get the phonemes component from a dictionary line. Lines are of the format: WORD PH1 PH2 PH3
     *
     * @param line - the dictionary line we want to get the phonemes from
     * @return a list containing the phonemes of the word in order.
     */
    //TODO - implement me!
    public static List<String> getPhonemesFromLine(String line) {
        List<String> phonemeList = new ArrayList<>();
        return phonemeList;
    }
}

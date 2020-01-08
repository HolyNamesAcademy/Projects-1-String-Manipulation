import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/** The representation of the CMU pronunciation dictionary. */
public class PhonemeDictionary {

    private static final String DEFAULT_DICTIONARY_FILE_PATH = "resources/cmudict.0.7a.txt";
    private Map<String, List<String>> phonemeDictionary;

    public PhonemeDictionary() {
        this(DEFAULT_DICTIONARY_FILE_PATH);
    }

    // Use this constructor directly if you want to test with a different (e.g. smaller) dictionary
    public PhonemeDictionary(String dictionaryFilePath) {
        phonemeDictionary = new HashMap<>();

        File f = new File(dictionaryFilePath);

        // When we put code inside a try{} block, it means we're watching out in case something goes wrong and the
        // program throws an exception.
        try {
            // We're creating a Scanner object, but this time instead of reading user input from System.in, it's going
            // to read input from the file.
            Scanner scanner = new Scanner(f);
            // Loop through the lines in the file and add the actual word entries to dictLines.
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                if (PhonemeDictionaryUtilities.isPhonemeEntry(line)) {
                    phonemeDictionary.put(PhonemeDictionaryUtilities.getWordFromLine(line), PhonemeDictionaryUtilities.getPhonemesFromLine(line));
                }
            }
        } catch (FileNotFoundException e) {
            // If anything in the try{} block causes a FileNotFound exception to be thrown, we end up here. If throwing
            // an exception is not the end of the world for our program, then we could do some error handling and just
            // return. Unfortunately, not being able to open the cmudict.0.7a.txt file means we have no dictionary
            // lines, so any further computation we do is going to be garbage. As such, the best thing we can do is to
            // print the stack trace and terminate the program with status code 1 (error).
            e.printStackTrace(System.err);
            System.out.println("Unable to produce rhymes at this time!");
            System.exit(1);
        }
    }

    /**
     * Getter all entries in the phoneme dictionary. This is the set of words that the dictionary has phonemes for.
     *
     * @return the list of all words in our dictionary
     */
    public List<String> getEntries() {
        return new ArrayList<>(phonemeDictionary.keySet());
    }

    /**
     * Returns the list of phonemes that make up the word being passed in.
     *
     * @param word - the word to get phonemes for.
     * @return a list of phonemes associated with word. An empty list is returned if the word is unrecognized.
     */
    public List<String> getPhonemes(String word) {
        return phonemeDictionary.getOrDefault(word.toUpperCase(), new ArrayList<>());
    }
}

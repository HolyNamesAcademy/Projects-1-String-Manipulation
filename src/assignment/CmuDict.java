package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The representation of the CMU pronunciation dictionary.
 */
public class CmuDict {
    private static ArrayList<String> dictLines;

    public CmuDict() {
        dictLines = new ArrayList();
        File f = new File("cmudict.0.7a.txt");
        try {
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                if (isWordEntry(line)) {
                    dictLines.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Check whether the given line is a dictionary entry for a word.
     * @param dictLine
     * @return true if the given line contains a word entry, false otherwise
     */
    private boolean isWordEntry(String dictLine) {
        return false;
    }

    /**
     * Get the word component of a solution.CmuDict line. Return the empty string if the line is invalid.
     * @param dictLine the dictionary line we want to extract the word from
     * @return the word part of dictLine
     */
    public static String getWord(String dictLine) {
        return null;
    }

    /**
     * Get the phonemes for a word from a CmuDict line. Return an empty array if the line is invalid.
     * @param dictLine the line we want to get the phonemes from
     * @return an array containing the phonemes of the word in order.
     */
    public static String[] getPhonemes(String dictLine) {
        return null;
    }

    /**
     * Find the line in the dictionary that corresponds to the given word. Return the empty string if the word cannot
     * be found.
     * @param word the word we want to find the line for
     * @return The line from dictLines which corresponds to word. If none is found, return the empty string.
     */
    public String getDictLineForWord(String word) {
        return null;
    }

    /**
     * Getter for the dictionary lines
     * @return the list of dictionary lines we've parsed
     */
    public ArrayList<String> getDictLines() {
        return dictLines;
    }

}

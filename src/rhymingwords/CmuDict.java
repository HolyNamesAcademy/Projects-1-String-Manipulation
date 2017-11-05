package rhymingwords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/** The representation of the CMU pronunciation dictionary. */
public class CmuDict {
    private static ArrayList<String> dictLines;

    public CmuDict() {
        // Initialize our dictionary as an empty list
        dictLines = new ArrayList();
        // Create a File object for the cmudict.0.7a.txt file in the project.
        File f = new File("cmudict.0.7a.txt");
        // When we put code inside a try{} block, it means we're watching out in case something goes wrong and the
        // program throws an exception.
        try {
            // We're creating a Scanner object, but this time instead of reading user input from System.in, it's going
            // to read input from the file.
            Scanner scanner = new Scanner(f);
            // Loop through the lines in the file and add the actual word entries to dictLines.
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                if (isWordEntry(line)) {
                    dictLines.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            // If anything in the try{} block causes a FileNotFound exception to be thrown, we end up here. If throwing
            // an exception is not the end of the world for our program, then we could do some error handling and just
            // return. Unfortunately, not being able to open the cmudict.0.7a.txt file means we have no dictionary
            // lines, so any further computation we do is going to be garbage. As such, the best thing we can do is to
            // print the stack trace and terminate the program with status code 1 (error).
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    /**
     * Check whether the given line is a dictionary entry for a word.
     * @param dictLine
     * @return true if the given line contains a word entry, false otherwise
     */
    public static boolean isWordEntry(String dictLine) {
        // TODO: implement this
        return false;
    }

    /**
     * Get the word component of a solution.CmuDict line. Return the empty string if the line is invalid.
     * @param dictLine the dictionary line we want to extract the word from
     * @return the word part of dictLine
     */
    public static String getWord(String dictLine) {
        // TODO: implement this
        return null;
    }

    /**
     * Get the phonemes for a word from a CmuDict line. Return an empty array if the line is invalid.
     * @param dictLine the line we want to get the phonemes from
     * @return an array containing the phonemes of the word in order.
     */
    public static String[] getPhonemes(String dictLine) {
        // TODO: implement this
        return null;
    }

    /**
     * Find the line in the dictionary that corresponds to the given word. Return the empty string if the word cannot
     * be found.
     * @param word the word we want to find the line for
     * @return The line from dictLines which corresponds to word. If none is found, return the empty string.
     */
    public String getDictLineForWord(String word) {
        // TODO: implement this
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

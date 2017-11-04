package rhymingwords;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object that will read user input.
        Scanner in = new Scanner(System.in);
        WordRhymer wordRhymer = new WordRhymer();
        // Ask the user what they want to do and read their response.
        System.out.print("Enter a command (\"quit\" or \"rhyme\"): ");
        String command = in.nextLine().toLowerCase();
        while (!command.equals("quit")) {
            if (!command.equals("rhyme")) {
                // The user issued an invalid command so we need to ask again.
                System.out.println("Command not recognized.");
            } else {
                // Ask the user which word they want to rhyme.
                System.out.println("Which word would you like to rhyme?");
                String wordToRhyme = in.nextLine();
                // Ask the user how many rhyming words to find.
                System.out.println("How many rhyming words would you like to find?");
                int numRhymingWords = in.nextInt();
                // Make sure the number of words to find is positive.
                while (numRhymingWords < 1) {
                    System.out.println("Please enter a positive number");
                    numRhymingWords = in.nextInt();
                }
                // When you type in a number (5, for instance,) and hit the return key, the computer reads the input
                // string as "5\n". We previously called in.nextInt(), and that will read in the 5, but leave the
                // newline character '\n' hanging. We call in.nextLine() to read in that remaining newline character and
                // print future output on the next line.
                in.nextLine();
                ArrayList<String> rhymingWords = wordRhymer.findRhymingWords(wordToRhyme, numRhymingWords);
                if (rhymingWords.isEmpty()) {
                    // We didn't find any rhyming words.
                    System.out.println("Found no words that rhymed with " + wordToRhyme);
                } else {
                    // We did find some rhyming words. Print out how many we found and which ones they were.
                    System.out.println("Found "+ rhymingWords.size() + " words that rhymed with " + wordToRhyme + ":");
                    for (String word : rhymingWords) {
                        System.out.println(word);
                    }
                }
            }
            // Ask the user again what they want to do and reads their response.
            System.out.print("Enter a command (\"quit\" or \"rhyme\"): ");
            command = in.nextLine().toLowerCase();
        }
    }
}

package assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordRhymer wordRhymer = new WordRhymer();
        System.out.print("Enter a command (\"quit\" or \"rhyme\"): ");
        String command = in.nextLine();
        while (!command.equals("quit")) {
            if (!command.equals("rhyme")) {
                System.out.println("Command not recognized.");
            } else {
                System.out.println("Which word would you like to rhyme?");
                String wordToRhyme = in.nextLine();
                System.out.println("How many rhyming words would you like to find?");
                int numRhymingWords = in.nextInt();
                while (numRhymingWords < 1) {
                    System.out.println("Please enter a positive number");
                    numRhymingWords = in.nextInt();
                }
                in.nextLine();
                ArrayList<String> rhymingWords = wordRhymer.findRhymingWords(wordToRhyme, numRhymingWords);
                if (rhymingWords.isEmpty()) {
                    System.out.printf("Found no words that rhymed with %s\n", wordToRhyme);
                } else {
                    System.out.printf("Found %d words that rhymed with %s:\n", rhymingWords.size(), wordToRhyme);
                    for (String word : rhymingWords) {
                        System.out.println(word);
                    }
                }
            }
            System.out.print("Enter a command (\"quit\" or \"rhyme\"): ");
            command = in.nextLine();
        }
    }
}

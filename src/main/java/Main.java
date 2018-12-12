import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        WordRhymer wordRhymer = new WordRhymer();

        System.out.print("Enter a command (\"quit\" or \"rhyme\"): ");
        String command = in.nextLine().toLowerCase();

        //Continue to rhyme unless the user asks to quit
        while (!command.equals("quit")) {
            if (!command.equals("rhyme")) {
                // The user entered something that was not "quit" or "rhyme".
                System.out.println("Command not recognized.");
            } else {
                System.out.println("Which word would you like to rhyme?");
                String wordToRhyme = in.nextLine();

                System.out.println("How many rhyming words would you like to find?");
                int numRhymingWords = in.nextInt();

                // Make sure the number of rhyming words to find is positive.
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
                    System.out.println("Found no words that rhymed with " + wordToRhyme);
                } else {
                    System.out.println("Found "+ rhymingWords.size() + " words that rhymed with " + wordToRhyme + ":");
                    for (String word : rhymingWords) {
                        System.out.println(word);
                    }
                }
            }

            // Does the user want to rhyme again?
            System.out.print("Enter a command (\"quit\" or \"rhyme\"): ");
            command = in.nextLine().toLowerCase();
        }
    }
}

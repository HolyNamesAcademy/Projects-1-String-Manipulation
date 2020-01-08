import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RhymeGenerator rhymeGenerator = new RhymeGenerator();

        System.out.print("Enter a command (\"quit\" or \"rhyme\"): ");
        String command = in.nextLine().toLowerCase();

        while (!command.equals("quit")) {
            if (!command.equals("rhyme")) {
                System.out.println("Command not recognized.");
            } else {
                System.out.print("Which word would you like to rhyme? ");
                String wordToRhyme = in.nextLine();

                //Make sure they entered a word.
                while (wordToRhyme.trim().equals("")) {
                    System.out.print("Please enter a word to rhyme. Try again: ");
                    wordToRhyme = in.nextLine();
                }

                System.out.print("How many rhyming words would you like to find? ");
                int numRhymingWords = in.nextInt();

                // Make sure the number of words to find is positive.
                while (numRhymingWords < 1) {
                    System.out.print("Please enter a positive number. Try again: ");
                    numRhymingWords = in.nextInt();
                }

                // When you type in a number (5, for instance,) and hit the return key, the computer reads the input
                // string as "5\n". We previously called in.nextInt(), and that will read in the 5, but leave the
                // newline character '\n' hanging. We call in.nextLine() to read in that remaining newline character and
                // print future output on the next line.
                in.nextLine();

                List<String> rhymingWords = rhymeGenerator.findRhymingWords(wordToRhyme.trim(), numRhymingWords);

                if (rhymingWords.isEmpty()) {
                    System.out.println(String.format("Could not find words that rhyme with: %s.", wordToRhyme));
                } else {
                    printRhymes(rhymingWords, wordToRhyme);
                }
            }
            // Ask the user again what they want to do and reads their response.
            System.out.println();
            System.out.print("Enter a command (\"quit\" or \"rhyme\"): ");
            command = in.nextLine().toLowerCase();
        }
    }

    /**
     * Print the rhyme report. If the word to rhyme with was 'educate' and the user asked for three rhyming words that
     * were found to be: DOMESTICATE, PONTIFICATE, COMMUNICATE, it should look like this:
     *     Found 3 words that rhyme with: educate
     *     Domesticate
     *     Pontificate
     *     Communicate
     *
     * @param rhymingWords - the list of rhyming words to display to the console
     * @param originalWord - the word the user asked to find rhymes for
     */
    public static void printRhymes(List<String> rhymingWords, String originalWord) {
        //TODO - implement me!
    }
}

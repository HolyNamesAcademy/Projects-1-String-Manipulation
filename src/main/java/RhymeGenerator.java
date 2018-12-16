import java.util.ArrayList;
import java.util.List;

/** Helper class for finding rhymes. */
public class RhymeGenerator {

    //The class that can provide possible rhymes, and determine if two words are rhymes
    private WordRhymer rhymer = new WordRhymer();

    /**
     * Generates a list up to numRhymingWords size of words that rhyme with wordToRhyme.
     * @param wordToRhyme the word to find rhyming words for
     * @param numRhymingWords the maximum number of rhyming words to find
     * @return A list containing words that rhyme with wordToRhyme. If no rhyming words can be found and empty list
     *         will be returned.
     */
    public List<String> findRhymingWords(String wordToRhyme, int numRhymingWords) {
        ArrayList<String> rhymes = new ArrayList<>();

        List<String> possibleRhymes = rhymer.getAllPossibleRhymes();
        for(String rhyme : possibleRhymes){
            if(!wordToRhyme.equalsIgnoreCase(rhyme) && rhymer.checkForRhyme(wordToRhyme, rhyme)){
                if (rhymes.size() == numRhymingWords){
                    break;
                }
                else{
                    rhymes.add(rhyme);
                }
            }
        }

        return rhymes;
    }


}
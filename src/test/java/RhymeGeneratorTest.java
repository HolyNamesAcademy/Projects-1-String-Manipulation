import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

/**
 * Test class for RhymeGenerator
 */
public class RhymeGeneratorTest {

    private RhymeGenerator rhymeGenerator = new RhymeGenerator();

    @Test
    public void findRhymingWords_oneRequestedOneExists() {
        String wordToRhymeWith = "Boast";
        int numberOfRhymesRequested = 1;

        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, numberOfRhymesRequested);

        assertTrue(String.format("Expected %d rhyme when requesting %d rhyme for %s, but received %d",
            numberOfRhymesRequested, numberOfRhymesRequested, wordToRhymeWith, rhymes.size()),
            rhymes.size() == numberOfRhymesRequested);
    }

    @Test
    public void findRhymingWords_oneRequestedNoneExists() {
        String wordToRhymeWith = "Balogna";
        int numberOfRhymesRequested = 1;

        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, numberOfRhymesRequested);

        assertTrue(String.format("Expected no rhymes when requesting %d rhyme for %s, but received %d",
            numberOfRhymesRequested, wordToRhymeWith, rhymes.size()), rhymes.size() == 0);
    }

    @Test
    public void findRhymingWords_multipleRequestedMultipleExist() {
        String wordToRhymeWith = "Plaid";
        int numberOfRhymesRequested = 3;

        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, numberOfRhymesRequested);

        assertTrue(String.format("Expected %d rhymes when requesting %d rhymes for %s, but received %d",
            numberOfRhymesRequested, numberOfRhymesRequested, wordToRhymeWith, rhymes.size()), rhymes.size() == 3);
    }

    @Test
    public void findRhymingWords_multipleRequestedMoreThanExist() {
        String wordToRhymeWith = "Dipole";
        int numberOfRhymesRequested = 15;

        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, numberOfRhymesRequested);

        assertTrue(String.format("Expected less than %d rhymes when requesting %d "
            + "rhymes for %s, received: %d", numberOfRhymesRequested, numberOfRhymesRequested, wordToRhymeWith,
            rhymes.size()), rhymes.size() < numberOfRhymesRequested);
        assertTrue(String.format("Expected more than zero rhymes when requesting %d "
            + "rhymes for  %s, received: %d", numberOfRhymesRequested, wordToRhymeWith, rhymes.size()),
            rhymes.size() > 0);

    }
}

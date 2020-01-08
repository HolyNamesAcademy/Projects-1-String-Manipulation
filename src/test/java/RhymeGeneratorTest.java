import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

/**
 * Test class for RhymeGenerator
 */
public class RhymeGeneratorTest {

    private RhymeGenerator rhymeGenerator = new RhymeGenerator();

    @Test
    public void findRhymingWords_oneRequestedAtLeastOneExists() {
        // Arrange
        String wordToRhymeWith = "Boast";
        int numberOfRhymesRequested = 1;

        // Act
        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, numberOfRhymesRequested);

        // Assert
        assertTrue(String.format("Expected %d rhyme when requesting %d rhyme for %s, but received %d",
                numberOfRhymesRequested, numberOfRhymesRequested, wordToRhymeWith, rhymes.size()),
                rhymes.size() == numberOfRhymesRequested);
    }

    @Test
    public void findRhymingWords_oneRequestedNoneExist() {
        // Arrange
        String wordToRhymeWith = "Balogna";
        int numberOfRhymesRequested = 1;

        // Act
        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, numberOfRhymesRequested);

        // Assert
        assertTrue(String.format("Expected no rhymes when requesting %d rhyme for %s, but received %d",
                numberOfRhymesRequested, wordToRhymeWith, rhymes.size()), rhymes.size() == 0);
    }

    @Test
    public void findRhymingWords_multipleRequestedMultipleExist() {
        // Arrange
        String wordToRhymeWith = "Plaid";
        int numberOfRhymesRequested = 3;

        // Act
        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, numberOfRhymesRequested);

        // Assert
        assertTrue(String.format("Expected %d rhymes when requesting %d rhymes for %s, but received %d",
                numberOfRhymesRequested, numberOfRhymesRequested, wordToRhymeWith, rhymes.size()), rhymes.size() == 3);
    }

    @Test
    public void findRhymingWords_multipleRequestedMoreThanExist() {
        // Arrange
        String wordToRhymeWith = "Dipole";
        int numberOfRhymesRequested = 15;

        // Act
        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, numberOfRhymesRequested);

        // Assert
        assertTrue(String.format("Expected less than %d rhymes when requesting %d "
                        + "rhymes for %s, received: %d", numberOfRhymesRequested, numberOfRhymesRequested, wordToRhymeWith,
                rhymes.size()), rhymes.size() < numberOfRhymesRequested);
        assertTrue(String.format("Expected more than zero rhymes when requesting %d "
                        + "rhymes for  %s, received: %d", numberOfRhymesRequested, wordToRhymeWith, rhymes.size()),
                rhymes.size() > 0);

    }

    @Test
    public void sanityTest1_findRhymingWords_validateCertainRhymesComeBack() {
        // Arrange
        String wordToRhymeWith = "complicate";

        // Act
        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, 500);
        System.out.println(rhymes.size());

        // Assert
        assertFalse("A word should not rhyme with itself.", listContains(rhymes, wordToRhymeWith));
        assertTrue("Expected indicate to rhyme with complicate.", listContains(rhymes, "indicate"));
        assertTrue("Expected locate to rhyme with complicate.", listContains(rhymes, "locate"));
        assertTrue("Expected educate to rhyme with complicate.", listContains(rhymes, "educate"));
        assertTrue("Expected fabricate to rhyme with complicate.", listContains(rhymes, "fabricate"));
    }


    @Test
    public void sanityTest2_findRhymingWords_validateCertainRhymesComeBack() {
        // Arrange
        String wordToRhymeWith = "dance";

        // Act
        List<String> rhymes = rhymeGenerator.findRhymingWords(wordToRhymeWith, 500);
        System.out.println(rhymes.size());

        // Assert
        assertFalse("A word should not rhyme with itself.", listContains(rhymes, wordToRhymeWith));
        assertTrue("Expected lance to rhyme with dance.", listContains(rhymes, "lance"));
        assertTrue("Expected france to rhyme with dance.", listContains(rhymes, "france"));
        assertTrue("Expected prance to rhyme with dance.", listContains(rhymes, "prance"));
        assertTrue("Expected glance to rhyme with dance.", listContains(rhymes, "glance"));
    }

    private boolean listContains(List<String> wordList, String wordToFind) {
        for (String word : wordList) {
            if (word.equalsIgnoreCase(wordToFind)) {
                return true;
            }
        }
        return false;
    }
}

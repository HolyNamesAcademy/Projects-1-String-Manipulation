import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

public class PhonemeDictionaryTest {


    @Test
    public void getEntries() {
        // Arrange
        PhonemeDictionary phonemeDictionary = new PhonemeDictionary("resources/tst/testCmuDict.txt");

        // Act
        List<String> allPhonemeEntries = phonemeDictionary.getEntries();

        // Assert
        assertTrue("The test dictionary has 12 phoneme entries. Expected 12 entries.", allPhonemeEntries.size() == 12);
        for(String entry : phonemeDictionary.getEntries()){
            assertFalse("An entry contains ';;;'. A comment has been included in the dictionary.", entry.contains(";;;"));
        }
    }

    @Test
    public void getPhonemes_phonemesExist_caseDoesNotMatch() {
        // Arrange
        PhonemeDictionary phonemeDictionary = new PhonemeDictionary("resources/tst/testCmuDict.txt");

        // Act
        List<String> phonemesForIce = phonemeDictionary.getPhonemes("Ice");

        // Assert
        assertFalse("Expected to find phonemes for Ice. None found.", phonemesForIce.isEmpty());
        assertTrue("Expected 2 phonemes. Found " + phonemesForIce.size(), phonemesForIce.size() == 2);
    }

    @Test
    public void getPhonemes_phonemesExist_caseDoesMatch() {
        // Arrange
        PhonemeDictionary phonemeDictionary = new PhonemeDictionary("resources/tst/testCmuDict.txt");

        // Act
        List<String> phonemesForIce = phonemeDictionary.getPhonemes("ICE");

        // Assert
        assertFalse("Expected to find phonemes for ICE. None found.", phonemesForIce.isEmpty());
        assertTrue("Expected 2 phonemes. Found " + phonemesForIce.size(), phonemesForIce.size() == 2);
    }

    @Test
    public void getPhonemes_noPhonemesForWord() {
        // Arrange
        PhonemeDictionary phonemeDictionary = new PhonemeDictionary("resources/tst/testCmuDict.txt");

        // Act
        List<String> phonemesForIce = phonemeDictionary.getPhonemes("Bananas");

        // Assert
        assertTrue("Found phonemes for a word not in the dictionary file: Bananas", phonemesForIce.isEmpty());
    }
}

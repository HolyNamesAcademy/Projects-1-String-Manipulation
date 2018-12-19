import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

public class PhonemeDictionaryTest {

    private PhonemeDictionary phonemeDictionary = new PhonemeDictionary("resources/tst/testCmuDict.txt");

    @Test
    public void getEntries() {
        List<String> allPhonemeEntries = phonemeDictionary.getEntries();

        assertTrue("The test dictionary has 12 phoneme entries. Expected 12 entries.", allPhonemeEntries.size() == 12);
        for(String entry : phonemeDictionary.getEntries()){
            assertFalse("An entry contains ';;;'. A comment has been included in the dictionary.",
                entry.contains(";;;"));
        }
    }

    @Test
    public void getPhonemes_phonemesExist_caseDoesNotMatch() {
        List<String> phonemesForIce = phonemeDictionary.getPhonemes("Ice");

        assertFalse("Expected to find phonemes for Ice. None found.", phonemesForIce.isEmpty());
        assertTrue("Expected 2 phonemes. Found " + phonemesForIce.size(), phonemesForIce.size() == 2);
    }

    @Test
    public void getPhonemes_phonemesExist_caseDoesMatch() {
        List<String> phonemesForIce = phonemeDictionary.getPhonemes("ICE");

        assertFalse("Expected to find phonemes for ICE. None found.", phonemesForIce.isEmpty());
        assertTrue("Expected 2 phonemes. Found " + phonemesForIce.size(), phonemesForIce.size() == 2);
    }

    @Test
    public void getPhonemes_noPhonemesForWord() {
        List<String> phonemesForIce = phonemeDictionary.getPhonemes("Bananas");

        assertTrue("Found phonemes for a word not in the dictionary file: Bananas", phonemesForIce.isEmpty());
    }
}

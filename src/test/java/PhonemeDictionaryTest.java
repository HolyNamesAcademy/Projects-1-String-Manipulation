import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

public class PhonemeDictionaryTest {

    private PhonemeDictionary phonemeDictionary = new PhonemeDictionary("resources/tst/testCmuDict.txt");

    @Test
    public void getEntries() {
        List<String> allPhonemeEntries = phonemeDictionary.getEntries();

        assertTrue(allPhonemeEntries.size() == 12);
        for(String entry : phonemeDictionary.getEntries()){
            assertFalse(entry.contains(";;;"));
        }
    }

    @Test
    public void getPhonemes_phonemesExist_caseDoesNotMatch() {
        List<String> phonemesForIce = phonemeDictionary.getPhonemes("Ice");
        assertFalse(phonemesForIce.isEmpty());
        assertTrue(phonemesForIce.size() == 2);
    }

    @Test
    public void getPhonemes_phonemesExist_caseDoesMatch() {
        List<String> phonemesForIce = phonemeDictionary.getPhonemes("ICE");
        assertFalse(phonemesForIce.isEmpty());
        assertTrue(phonemesForIce.size() == 2);
    }

    @Test
    public void getPhonemes_noPhonemesForWord() {
        List<String> phonemesForIce = phonemeDictionary.getPhonemes("Bananas");
        assertTrue(phonemesForIce.isEmpty());
    }
}

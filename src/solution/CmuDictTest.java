package solution;

import org.junit.Test;
import static org.junit.Assert.*;

public class CmuDictTest {

    /* Check that we correctly extract a word from a dictionary line */
    @Test
    public void testGetWord_ValidLine() {
        String dictLine = "HAMSTRING  HH AE1 M S T R IH2 NG";
        String expectedWord = "HAMSTRING";

        String word = CmuDict.getWord(dictLine);

        assertEquals(expectedWord, word);
    }

    /* Check that we don't extract a word from an invalid dictionary line */
    @Test
    public void testGetWord_InvalidLine() {
        String dictLine = "Happy birthday to you";
        String expectedWord = "";

        String word = CmuDict.getWord(dictLine);

        assertEquals(expectedWord, word);
    }

    /* Check that we correctly extract the phonemes from a dictionary line */
    @Test
    public void testGetPhonemes_ValidLine() {
        String dictLine = "HAMSTRING  HH AE1 M S T R IH2 NG";
        String[] expectedPhonemes = {"HH", "AE1", "M", "S", "T", "R", "IH2", "NG"};

        String[] phonemes = CmuDict.getPhonemes(dictLine);

        for (int i = 0; i < phonemes.length; i++) {
            assertEquals(expectedPhonemes[i], phonemes[i]);
        }
    }

    /* Check that we don't extract the phonemes from an invalid dictionary line */
    @Test
    public void testGetPhonemes_InvalidLine() {
        String dictLine = "Nothing to see here";

        String[] phonemes = CmuDict.getPhonemes(dictLine);

        assertEquals(0, phonemes.length);
    }

    /* Check that we correctly find the line for a word that exists in the dictionary */
    @Test
    public void testGetDictLineForWord_ValidWord() {
        CmuDict cmuDict = new CmuDict();
        String expectedLine = "HAMSTRING  HH AE1 M S T R IH2 NG";

        String line = cmuDict.getDictLineForWord("hamstring");

        assertEquals(expectedLine, line);
    }

    /* Check that we don't find a line for a word that isn't in the dictionary */
    @Test
    public void testGetDictLineForWord_InvalidWord() {
        CmuDict cmuDict = new CmuDict();
        String expectedLine = "";

        String line = cmuDict.getDictLineForWord("spongebob");

        assertEquals(expectedLine, line);
    }


}

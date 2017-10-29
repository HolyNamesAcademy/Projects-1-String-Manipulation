package solution;

import org.junit.Test;

public class WordRhymerTest {

    /* Test that two arrays of phonemes match at the final 5 */
    @Test
    public void testFinalPhonemesMatch_SameLast5Phonemes() {
        String[] phonemes1 = { "HH", "AE1", "M", "S", "T", "R", "IH2", "NG" };
        String[] phonemes2 = { "S", "T", "R", "IH2", "NG" };

        boolean matchingPhonemes = WordRhymer.finalPhonemesMatch(phonemes1, phonemes2);

        assert(matchingPhonemes);
    }

    /* Test that two arrays of phonemes do have the same final phonemes even if one isn't 5 phonemes long */
    @Test
    public void testFinalPhonemesMatch_ShortArraysOfPhonemesMatch() {
        String[] phonemes1 = { "HH", "AE1", "M", "S", "T", "R", "IH2", "NG" };
        String[] phonemes2 = { "R", "IH2", "NG" };

        boolean matchingPhonemes = WordRhymer.finalPhonemesMatch(phonemes1, phonemes2);

        assert(matchingPhonemes);
    }

}

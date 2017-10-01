package solution;

import org.junit.Test;

public class WordRhymerTest {

    @Test
    public void testFinalPhonemesMatch_SameLast3Phonemes() {
        String[] phonemes1 = { "HH", "AE1", "M", "S", "T", "R", "IH2", "NG" };
        String[] phonemes2 = { "S", "T", "R", "IH2", "NG" };

        boolean matchingPhonemes = WordRhymer.finalPhonemesMatch(phonemes1, phonemes2);

        assert(matchingPhonemes);
    }
}

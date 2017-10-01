package solution;

import org.junit.Test;

public class CmuDictTest {

    @Test
    public void testGetWord_WordExists() {
        String dictLine = "HAMSTRING  HH AE1 M S T R IH2 NG";

        String word = CmuDict.getWord(dictLine);

        assert(word.equals("HAMSTRING"));
    }
}

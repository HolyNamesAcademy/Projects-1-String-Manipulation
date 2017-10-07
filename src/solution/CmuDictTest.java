package solution;

import org.junit.Test;

import java.util.ArrayList;

public class CmuDictTest {

    @Test
    public void testGetDictLines_Size() {
        // Arrange
        CmuDict testDictionary = new CmuDict();
        int expectedSize = 133218;

        // Act
        ArrayList<String> testLines = testDictionary.getDictLines();

        // Assert
        assert(testLines.size() == expectedSize);
    }

    @Test
    public void testGetWord_WordExists() {
        String dictLine = "HAMSTRING  HH AE1 M S T R IH2 NG";

        String word = CmuDict.getWord(dictLine);

        assert(word.equals("HAMSTRING"));
    }
}

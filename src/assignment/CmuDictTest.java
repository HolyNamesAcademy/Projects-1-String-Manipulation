package assignment;

import org.junit.Test;
import solution.CmuDict;

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
        // TODO: test that we successfully extract a word from a valid dict line
    }
}

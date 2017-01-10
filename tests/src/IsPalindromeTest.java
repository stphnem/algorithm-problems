import Arrays.ArrayQuestions;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IsPalindromeTest {

    ArrayQuestions q;

    @Before
    public void setup() {
        q = new ArrayQuestions();
    }

    @Test
    public void testInvalidPalindrom() {
        assertEquals(false, q.isPalindrome("ab"));
    }

    @Test
    public void testToHex() {
        q.toHex(21);
    }
}

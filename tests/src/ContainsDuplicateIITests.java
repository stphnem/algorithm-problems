import HashMap.HashMapQuestions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContainsDuplicateIITests {

    HashMapQuestions q;

    @org.junit.Before
    public void setup() {
        q = new HashMapQuestions();
    }

    @Test
    public void testEmptyArray() {
        int[] a = new int[0];
        assertEquals(false, q.containsNearbyDuplicate(a, 1));
    }

    @Test
    public void testOneItem() {
        int[] a = new int[1];
        assertEquals(false, q.containsNearbyDuplicate(a, 1));
    }

    @Test
    public void testInvalidK() {
        int[] a = new int[] {4, 0, 4};
        assertEquals(false, q.containsNearbyDuplicate(a, 1));
    }

    @Test
    public void testValidK() {
        int[] a = new int[] {4, 1, 3, 6, 4, 8, 9};
        assertEquals(true, q.containsNearbyDuplicate(a, 3));
    }
}

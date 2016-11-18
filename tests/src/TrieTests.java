import org.junit.Before;
import org.junit.Test;

public class TrieTests {

    Trie t;

    @Before
    public void setup() {
        t = new Trie();
    }

    @Test
    public void testInsertSingleWord() {
        t.insert("apple");
        
    }


}

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    public char c;
    boolean isEnd = false;
    public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode() {}

    public TrieNode(char c) { this.c = c; }
}

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String s) {
        Map<Character, TrieNode> children = root.children;

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode t;

            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            if (i == s.length()) {
                t.isEnd = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if (t != null && t.isEnd) {
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String s) {
        TrieNode t = null;
        Map<Character, TrieNode> children = root.children;

        for (char c : s.toCharArray()) {
            if (children.containsKey(c)) {
                t = children.get(t);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }
}
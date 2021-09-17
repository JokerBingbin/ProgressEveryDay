package leetCode.tree;

import org.junit.Test;

public class TrieTest {

    @Test
    public void testTrie() {
        Trie trie = new Trie();
        trie.insert("wanwanwanzi");
        System.out.println(trie.search("wanwanwanzi"));
        System.out.println(trie.startsWith("wanwanwanzi"));
    }

}

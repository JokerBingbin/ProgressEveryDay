package leetCode.dailyQuestion;

import java.util.List;
import org.junit.Test;


public class WordSearchIITest {

    @Test
    public void testFindWords() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        WordSearchII search = new WordSearchII();
        List<String> list = search.findWords(board, words);
        for(String str: list) {
            System.out.println(str);
        }

    }

    @Test
    public void testFindWords2() {
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String[] words = {"abcd"};
        WordSearchII search = new WordSearchII();
        List<String> list = search.findWords(board, words);
        for(String str: list) {
            System.out.println(str);
        }

    }

}

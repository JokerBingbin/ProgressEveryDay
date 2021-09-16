package leetCode.dailyQuestion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 查找单词II
 * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 */
public class WordSearchII {

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 这题需要用到一个数据结构：字典树。
     * 字典树是一种搜索效率极高的树， 如果搜索的单词长度为S，那么搜索的时间复杂度为O(s)
     * 这题我们先把所有word加入到字典树中，然后对字符网格中每一个字符进行遍历。
     * 因为题目要求同一单元格内的字母不能重复使用，所以在遍历的时候需要先设置为一个非字母的字符即可。
     */
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }

        Set<String> res = new HashSet<>();
        for (int i = 0 ; i < board.length; i++) {
            for(int j = 0; j < board[0].length ; j++) {
                dfs(board, i, j, trie, res);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int i, int j, Trie trie, Set<String> res) {
        // 不是子结点
        if (!trie.children.containsKey(board[i][j])) {
            return;
        }

        char c = board[i][j];
        System.out.println(c);
        Trie t = trie.children.get(c);
        // 是叶子结点
        if (!t.word.equals("")) {
            res.add(t.word);
            t.word = "";
        }

        // 是非叶子结点
        if (!t.children.isEmpty()) {
            board[i][j] = '#';
            for(int[] dir : dirs) {
                int i1 = i + dir[0];
                int j1 = j + dir[1];
                if (i1 >= 0 && i1 < board.length && j1 >= 0 && j1 < board[0].length) {
                    dfs(board, i1, j1, t, res);
                }
            }
            board[i][j] = c;
        }

        // 删除已遍历的
        if (t.children.isEmpty()) {
            trie.children.remove(c);
        }
    }

    class Trie {
        String word;
        HashMap<Character, Trie> children;

        public Trie() {
            this.word = "";
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0;i < word.length(); i++) {
                Character c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Trie());
                }
                node = node.children.get(c);
            }
            node.word = word;
        }
    }

}


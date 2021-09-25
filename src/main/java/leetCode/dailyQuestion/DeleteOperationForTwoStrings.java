package leetCode.dailyQuestion;

/**
 * 两个字符串的删除操作
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 */
public class DeleteOperationForTwoStrings {

    /**
     * 这道题本质就是求最长公共子序列。
     * 把最长公共子序列的长度求出来，分别拿两个字符串的长度减去，再加起来即可。
     * 对于最长公共子序列，一道经典的动态规划题目。
     */
    public int minDistance(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        int[][] dp = new int[size1+1][size2+1];
        for (int i = 0; i < size1 + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < size2 + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < size1 + 1;i++) {
            for (int j = 1; j < size2 + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return size1 + size2 - 2 * dp[size1][size2];

    }
}

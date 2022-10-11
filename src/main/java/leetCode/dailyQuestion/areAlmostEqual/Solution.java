package leetCode.dailyQuestion.areAlmostEqual;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 *
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int diff = 0;
        char[][] diffChar = new char[2][2];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff ++;
                if (diff > 2) {
                    return false;
                }
                diffChar[0][diff - 1] = s1.charAt(i);
                diffChar[1][diff - 1] = s2.charAt(i);
            }
        }
        return diffChar[0][1] == diffChar[1][0] && diffChar[0][0] == diffChar[1][1];
    }
}

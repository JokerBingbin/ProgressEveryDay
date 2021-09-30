package leetCode.dailyQuestion.LengthOfLastWord;

/**
 * 最后一个单词的长度
 *
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串.
 */
public class Solution {

    /**
     * 力扣想让大家过中秋 所以今天的每日一题格外简单。
     * 要求最后一个单词的长度 从后往前屁遍历即可。
     */
    public int lengthOfLastWord(String s) {
        int n = s.length();
        if ( n == 0) {
            return 0;
        }
        int i = n - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i --;
        }
        int res = 0;
        while (i >=0 && s.charAt(i) != ' ') {
            res ++;
            i --;
        }
        return res;

    }
}

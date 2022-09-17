package leetCode.dailyQuestion.maxLengthBetweenEqualCharacters;

import java.util.Arrays;

public class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firsts = new int[26];
        Arrays.fill(firsts, -1);
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firsts[c - 'a'] == -1) {
                firsts[c - 'a'] = i;
            } else {
                max = Math.max(max, i - firsts[c - 'a'] - 1);
            }
        }
        return max;
    }

}

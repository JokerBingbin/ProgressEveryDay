package leetCode.dailyQuestion.OrderlyQueue;

import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String min = s;
            StringBuilder sb = new StringBuilder(s);
            int n = s.length();
            for (int i = 1;i < n;i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(min) < 0) {
                    min = sb.toString();
                }
            }
            return sb.toString();
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
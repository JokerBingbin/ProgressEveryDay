package leetCode.dailyQuestion.beautifulArrangementII;

import java.util.Arrays;

public class Solution {


    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0;i < n - k - 1; i++) {
            res[i] = i + 1;
        }
        int help = 1;
        int afterTmp = 0;
        int beforeTmp = n - k;
        for (int i = n - k - 1; i < n; i++) {
            if (help % 2 == 1) {
                res[i] = beforeTmp++;
            } else {
                res[i] = n - (afterTmp++);
            }
            help ++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 4;
        System.out.println(Arrays.toString(new Solution().constructArray(n, k)));
    }


}

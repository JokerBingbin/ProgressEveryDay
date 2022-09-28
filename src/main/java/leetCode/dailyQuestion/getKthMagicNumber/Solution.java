package leetCode.dailyQuestion.getKthMagicNumber;

/**
 * 面试题 17.09. 第 k 个数
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * https://leetcode.cn/problems/get-kth-magic-number-lcci/solution/
 */
public class Solution {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int dp3 = 1, dp5 = 1, dp7 = 1;
        for (int i = 2;i <= k; i++) {
            int num3 = dp[dp3] * 3;
            int num5 = dp[dp5] * 5;
            int num7 = dp[dp7] * 7;
            dp[i] = Math.min(Math.min(num3, num5), num7);
            if (dp[i] == num3) {
                dp3 ++;
            }
            if (dp[i] == num5) {
                dp5 ++;
            }
            if (dp[i] == num7) {
                dp7 ++;
            }
        }
        return dp[k];
    }

}

package leetCode.dailyQuestion.TwoKeysKeyboard;


/**
 * 只有两个键的键盘
 *
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 *
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2-keys-keyboard
 */
public class Solution {

    /**
     * 要得到i个A, 且j是i的因数，那就需要dp[j] + i/j 次。
     * 所以我们只需要遍历i的因数，取出最少的次数即可。
     * 状态转换方程：dp[i] = min (dp[j] + i/j, dp[i])
     * 在遍历i的因数时，只需要遍历到根号i即可。
     */
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1;j * j <= i; j++) {
                if (i % j == 0){
                    dp[i] = Math.min(dp[i], dp[j] + i/j);
                    dp[i] = Math.min(dp[i], dp[i/j] + j);
                }
            }
        }
        return dp[n];
    }
}

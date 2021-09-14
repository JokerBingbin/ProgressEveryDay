package leetCode.dynamicProgramming;

/**
 * 最少硬币问题，动态规划的入门基础题。
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 2];
        if(amount == 0) {
            return 0;
        }
        dp[0] = 0;
        for (int i = 1;i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin: coins) {
                if(coin > i || dp[i - coin] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}

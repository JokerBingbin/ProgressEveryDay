package leetCode.dailyQuestion;

/**
 *  最长递增子序列的个数
 *
 * 给定一个未排序的整数数组，找到最长递增子序列的个数
 */
public class NumberOfLongestIncreasingSubsequence {

    /**
     * 这道题是寻找最长递增子序列长度的进化形态。
     * 但是思路是和找出最长递增子序列长度是一样的。
     * 不过需要再用一个辅助数组来记录到nums[i]的最长子序列的个数。
     * 最终的结果就是所有长度等于max的子序列 的 cnt[i]的和
     */
    public int findNumberOfLIS(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        int[] cnt = new int[size];
        int max = 0;
        int res = 0;
        for (int i = 0;i < size;i ++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > max) {
                res = cnt[i];
                max = dp[i];
            } else if (dp[i] == max) {
                res += cnt[i];
            }
        }
        return res;
    }

}

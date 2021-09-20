package leetCode.dynamicProgramming;


/**
 * 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */
public class LongestIncreasingSubsequence {

    /**
     * 看到子序列 最长 直接浮现动态规划
     * 因为子序列不要求连续，所以我们两重遍历数组。
     * 如果nums[i] 比 nums[j]大，  那么到nums[i]为止肯定有dp[j] + 1长的递增子序列。
     * 遍历结束后即可。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = 1;
        int max = 1;
        for (int i = 1;i < size; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}

package leetCode.dailyQuestion.trimMean;


import java.util.Arrays;

/**
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 *
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
 *
 * https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 */
public class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int removeSize = (int) (arr.length * 0.05);
        double sum = 0;
        for (int i = removeSize; i < arr.length - removeSize; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - 2 * removeSize);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trimMean(new int[]{6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4}));
    }
}

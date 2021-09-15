package leetCode.dailyQuestion;

/**
 * 寻找峰值
 *
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 */
public class FindPeakElement {

    /**
     * 要寻找峰值，简单嘛，遍历一遍数组找到第一个峰值就行了。
     * 什么？时间复杂度为O(log n)?
     * 那没办法了，遍历的复杂度O(n)肯定超时了。
     * 那就用二分搜索吧。虽然数组不是一个有序数组，但是他是局部有序的。就像群山一样，其实就是一个个坡。
     * 二分搜索的思路在于缩小查找范围。
     * 如果一个数左边递增，那么它右边一定有一个峰值；如果一个数右边递减，那么它左边一定有一个峰值。
     * 就像滑梯一样，找到中间的点，然后往低的方向走。
     */
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}

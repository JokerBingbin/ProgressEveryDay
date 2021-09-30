package leetCode.algorithm.KthLargestElementInAnArray;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        int n = nums.length;
        for (int i = k;i < n; i++) {
            if (heap.peek() < nums[i]) {
                heap.remove();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();

    }
}

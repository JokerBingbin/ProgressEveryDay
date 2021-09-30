package leetCode.algorithm.MedianOfTwoSortedArrays;

/**
 * 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length, size2 = nums2.length;
        int index = 0;
        int mid = (size1 + size2) / 2;
        int i = 0, j = 0;
        int flag = 1;
        while (index <= mid) {
            if (nums1[i] <= nums2[j]) {
                i++;
                flag = 1;
            } else {
                j ++;
                flag = 2;
            }
            index ++;
        }
        double res = flag == 1 ? nums1[i-1] : nums2[j-1];
        if ((size1 + size2) % 2 == 0) {
            res += Math.min(nums1[i], nums2[j]);
            res /= 2;
        }
        return res;
    }

    public static double solution(int[] nums1, int[] nums2) {
        int size1 = nums1.length, size2 = nums2.length;
        int n = size1 + size2;
        double[] arr = new double[n];
        int i = 0, j = 0, k = 0;
        for (i = 0; i < n; i++) {
            if (j == size1) {
                arr[i] = nums2[k];
                k++;
            } else if (k == size2 || nums1[j] <= nums2[k]) {
                arr[i] = nums1[j];
                j++;
            } else if (nums1[j] > nums2[k]) {
                arr[i] = nums2[k];
                k++;
            }
        }
        n -= 1;
        return n % 2 == 1 ? (arr[n/2] + arr[n/2 + 1]) / 2 : arr[n/2];

    }
}

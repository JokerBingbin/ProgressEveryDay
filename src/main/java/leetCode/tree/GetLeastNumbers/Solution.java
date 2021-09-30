package leetCode.tree.GetLeastNumbers;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Solution {

    /**
     * 要最小的k个数，第一反应肯定是排序。但是排序算法的时间复杂度普遍较高。
     * 这里我们使用堆排序。维护一个大小为k的大顶堆，把数组里的数都遍历一遍，堆剩下的数就是最小的k个数
     * 先把前k个数插入大顶堆，再遍历。如果遍历到的数小于大顶堆的堆顶的数，就把堆顶弹出，便利的数插入。
     * Java提供了一个堆的类PriorityQueue
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        // 创建一个最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i ++) {
            heap.offer(arr[i]);
        }
        for (int i = k;i < arr.length; i++) {
            if(heap.element() > arr[i]) {
                heap.remove();
                heap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i ++) {
            res[i] = heap.remove();
        }
        return res;
    }
}

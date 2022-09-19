package leetCode.dailyQuestion.frequencySort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 1636. 按照频率将数组升序排序
 *
 * 给你一个整数数组nums.请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 *
 * 请你返回排序后的数组。
 *
 * https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 */
public class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num :nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int cnt1 = map.get(a), cnt2 = map.get(b);
            return cnt1 == cnt2? b-a : cnt1 - cnt2;
        });
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}

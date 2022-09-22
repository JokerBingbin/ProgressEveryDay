package leetCode.dailyQuestion.canFormArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 能否连接形成数组
 *
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 *
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/check-array-formation-through-concatenation/
 */
public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length, m = pieces.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ;i < m; i++) {
            map.put(pieces[i][0], i);
        }
        for (int i = 0;i < n;) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int index = map.get(arr[i]);
            int len = pieces[index].length;
            for (int j = 0;j < len; j++) {
                if (arr[i + j] != pieces[index][j]){
                    return false;
                }
            }
            i += len;
        }
        return true;
    }
}

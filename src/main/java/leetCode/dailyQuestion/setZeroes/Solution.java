package leetCode.dailyQuestion.setZeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  https://leetcode.cn/problems/zero-matrix-lcci/
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<int[]> set = new HashSet<>();
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0;i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    set.add(new int[]{i, j});
                }
            }
        }
        for (int[] ints : set) {
            int l = ints[0], r = ints[1];
            for (int i = 0; i < n; i++) {
                matrix[i][r] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[l][i] = 0;
            }
        }
    }
}

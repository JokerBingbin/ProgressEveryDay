package leetCode.dailyQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 回旋镖的数量
 * 给定平面上n对 互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 */
public class NumberOfBoomerangs {


    /**
     * 暴力枚举，把数组中的每一个点都当作中间的点，然后枚举每一种情况。
     */
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int size = points.length;
        if (size == 0) {
            return  0;
        }
        for (int i = 0; i < size; i++) {
            map.clear();
            // 这一步是把每个点和选中的点距离算出来，HashMap的键值对是<距离，数量>
            for (int[] point : points) {
                int dis = (point[0] - points[i][0])*(point[0] - points[i][0]) + (point[1] - points[i][1])*(point[1] - points[i][1]);
                // 把是这个距离的数量+1
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int n = entry.getValue();
                // 有n个点和这个点的距离相同， 因为要考虑顺序，所以是n*(n-1)
                res += n * (n - 1);
            }
        }
        return res;
    }

}

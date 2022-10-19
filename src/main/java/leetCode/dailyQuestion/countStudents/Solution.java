package leetCode.dailyQuestion.countStudents;

import java.util.Arrays;

/**
 * 1700. 无法吃午餐的学生数量
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 *
 * 如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 * 否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 给你两个整数数组 students 和 sandwiches ，
 * 其中 sandwiches[i] 是栈里面第 i 个三明治的类型（i = 0 是栈的顶部）， students[j] 是初始队列里第 j 名学生对三明治的喜好（j = 0 是队列的最开始位置）。
 * 请你返回无法吃午餐的学生数量。
 *
 * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 */
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0 ;i < students.length; i++) {
            if (sandwiches[i] == 1 && s1 > 0) {
                s1 --;
            } else if (sandwiches[i] == 0 && s0 > 0) {
                s0 --;
            } else {
                break;
            }
        }
        return s0 + s1;
    }

    public static void main(String[] args) {
        int[] students = new int[]{0,0,0,1,1,1,1,0,0,0};
        int[] san = new int[]{1,0,1,0,0,1,1,0,0,0};
        System.out.println(new Solution().countStudents(students, san));
    }
}

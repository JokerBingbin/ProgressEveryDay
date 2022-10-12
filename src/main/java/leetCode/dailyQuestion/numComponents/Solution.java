package leetCode.dailyQuestion.numComponents;

import leetCode.LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 *
 * https://leetcode.cn/problems/linked-list-components/
 */
public class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        boolean flag = false;
        int res = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!flag) {
                    flag = true;
                    res ++;
                }
            } else {
                flag = false;
            }
            head = head.next;
        }
        return res;
    }
}

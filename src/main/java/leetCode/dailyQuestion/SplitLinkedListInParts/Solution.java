package leetCode.dailyQuestion.SplitLinkedListInParts;

import leetCode.LinkedList.ListNode;

/**
 * 分隔链表
 *
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 *
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 *
 * 返回一个由上述 k 部分组成的数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 */
public class Solution {

    /**
     * 先计算出链表长度length, 然后用length/k得到每组的长度，因为可能除不尽，SuperWashingMachines所以还要记录一下余数remainder = length % k
     * 那么前remainder个每个长度再+1即可。
     * 一道比较简单的中等题。
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length ++;
            temp = temp.next;
        }
        int size = length / k;
        int remainder = length % k;
        ListNode pre = head;
        ListNode[] res = new ListNode[k];
        for (int i = 0;i < k && pre != null; i ++) {
            res[i] = pre;
            int partSize = size + (i < remainder ? 1 : 0);
            for (int j = 1;j < partSize; j++) {
                pre = pre.next;
            }
            ListNode next = pre.next;
            pre.next = null;
            pre = next;
        }
        return res;
    }

}

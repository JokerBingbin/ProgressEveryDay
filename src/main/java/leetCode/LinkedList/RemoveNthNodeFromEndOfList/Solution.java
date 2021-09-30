package leetCode.LinkedList.RemoveNthNodeFromEndOfList;

import leetCode.LinkedList.ListNode;

/**
 * 删除链表的倒数第N个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 */
public class Solution {

    /**
     *  双指针法
     *  先让尾指针往前移动n个位置，然后前后指针一起移动。
     *  让尾指针移动到链表尾部的时候，头指针的下一个就是我们要删除的结点。
     *  因为也会涉及到删除最开始的头指针，所以这里我用了一个临时结点当作头指针，以防出现空指针异常。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode tail = pre;
        head = pre;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }
        while (tail.next != null) {
            tail = tail.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head.next;
    }



}

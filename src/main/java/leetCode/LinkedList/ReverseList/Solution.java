package leetCode.LinkedList.ReverseList;


import leetCode.LinkedList.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Solution {

    /**
     * 利用头插法反转。每次把下一个结点插到本结点的前面即可。
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre.next;
    }
}

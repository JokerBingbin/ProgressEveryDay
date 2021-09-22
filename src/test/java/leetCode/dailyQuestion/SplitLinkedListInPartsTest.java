package leetCode.dailyQuestion;

import leetCode.LinkedList.ListNode;
import org.junit.Test;

public class SplitLinkedListInPartsTest {

    @Test
    public void testSplitListToParts() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        SplitLinkedListInParts solution = new SplitLinkedListInParts();
        ListNode[] list = solution.splitListToParts(head, 5);
        for (ListNode node : list) {
            System.out.println(node.val);
        }
    }
}

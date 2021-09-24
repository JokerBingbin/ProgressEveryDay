package leetCode.dailyQuestion;

/**
 *
 * 扁平化多级双向链表
 *
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。

 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 *
 */
public class FlattenAMultilevelDoublyLinkedList {

    /**
     * 深度优先遍历。
     * 在遍历的过程中，如果该结点有子结点，那么就先保存下node.next, 然后将node.child连到node.next上，对node.child再遍历。
     * node.child遍历结束后，再把刚才保存的node.next接上即可。
     */
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        dfs(head, null);
        return head;
    }

    public void dfs(Node node, Node next) {
        Node pre = node;
        while (node != null) {
            if (node.child != null) {
                Node parentNext = node.next;
                if (parentNext != null){
                    parentNext.prev = null;
                }
                node.next = node.child;
                node.child = null;
                node.next.prev = node;
                dfs(node.next, parentNext);
            }
            pre = node;
            node = node.next;
        }
        if (next != null){
            next.prev = pre;
        }
        pre.next = next;
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

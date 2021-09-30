package leetCode.tree.PostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import leetCode.tree.TreeNode;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversalWithRecursion(root, res);
        return res;
    }

    /**
     * 递归，后序遍历  left -> right -> root
     */
    protected void traversalWithRecursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return ;
        }

        traversalWithRecursion(node.left, list);
        traversalWithRecursion(node.right, list);
        list.add(node.val);
    }

    /**
     * 用栈
     */
    protected void traversalWithStack(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == pre) {
                pre = node;
                list.add(node.val);
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
    }


}

package leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversalWithRecursion(root, res);
        return res;
    }

    /**
     * 递归方法，先序遍历是先遍历根节点，再遍历左子树，然后是右子树
     * root -> leftChild -> rightChild
     */
    protected void traversalWithRecursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return ;
        }

        list.add(node.val);
        traversalWithRecursion(node.left, list);
        traversalWithRecursion(node.right, list);
    }


    /**
     * 利用栈
     */
    protected void traversalWithStack(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
    }


}

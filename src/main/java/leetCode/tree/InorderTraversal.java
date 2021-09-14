package leetCode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversalWithRecursion(root, res);
        return res;
    }

    /**
     * 递归 中序遍历是先遍历左子树，在根节点，最后右子树
     * left -> root -> right
     *
     */
    protected void traversalWithRecursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return ;
        }
        traversalWithRecursion(node.left, list);
        list.add(node.val);
        traversalWithRecursion(node.right, list);
    }


    /**
     * 用栈
     */
    protected void traversalWithStack(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
    }


}

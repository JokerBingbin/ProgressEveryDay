package leetCode.tree.PathSum;

import leetCode.tree.TreeNode;

/**
 * 路径总和
 *
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 */
public class Solution {

    /**
     * 思路是递归
     * 从root到叶子结点需要结点值总和为targetSum, 那就判断是否root.left到叶子结点的路径总和为targetSum - root.val
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}

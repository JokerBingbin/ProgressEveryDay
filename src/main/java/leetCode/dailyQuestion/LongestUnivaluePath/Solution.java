package leetCode.dailyQuestion.LongestUnivaluePath;

import leetCode.tree.TreeNode;

public class Solution {

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;

    }


    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftChild = dfs(root.left);
        int rightChild = dfs(root.right);
        int left = 0;
        int right = 0;
        if (root.left != null && root.left.val == root.val) {
            left = leftChild + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right = rightChild + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}

package leetCode.dailyQuestion.MaximumBinaryTreeII;

import leetCode.tree.TreeNode;

public class Solution {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (val > root.val) {
            return new TreeNode(val, root, null);
        }
        TreeNode tmp = root.right;
        TreeNode parent = root;
        while (tmp != null) {
            if (val > tmp.val) {
                parent.right = new TreeNode(val, tmp, null);
                return root;
            }
            parent = tmp;
            tmp = tmp.right;
        }
        parent.right = new TreeNode(val, null, null);
        return root;
    }


}

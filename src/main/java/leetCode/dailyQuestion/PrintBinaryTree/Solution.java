package leetCode.dailyQuestion.PrintBinaryTree;

import leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        List<List<String>> res = new ArrayList<>();
        int m = depth + 1;
        int n = (1 << depth + 1) - 1;
        for (int i = 0;i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0;j < n; j++) {
                row.add("");
            }
            res.add(row);
        }
        dfs(root, res, 0, (n - 1)/2, depth);
        return res;
    }

    public int getDepth(TreeNode root) {
        int h = 0;
        if (root.left != null) {
            h = Math.max(h, getDepth(root.left) + 1);
        }
        if (root.right != null) {
            h = Math.max(h, getDepth(root.right) + 1);
        }
        return h;
    }

    private void dfs(TreeNode node, List<List<String>> res, int r, int c, int height) {
        res.get(r).set(c, String.valueOf(node.val));
        if (node.left != null) {
            dfs(node.left, res, r + 1, c - (1 << height - r - 1), height);
        }
        if (node.right != null) {
            dfs(node.right, res, r+1, c+(1 << height - r - 1) ,height);
        }
    }

}

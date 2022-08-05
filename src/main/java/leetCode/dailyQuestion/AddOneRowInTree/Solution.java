package leetCode.dailyQuestion.AddOneRowInTree;

import leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        } else if (depth == 1) {
            TreeNode node = new TreeNode(val, root, null);
            return node;
        } else if (depth == 2) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(val, left, null);
            root.right = new TreeNode(val, null, right);
            return root;
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
            return root;
        }
    }

    private TreeNode addOneRowOfBFS(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        for (int i = 1;i < depth - 1; i++) {
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : nodeList) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            nodeList = tmp;
        }
        for (TreeNode node : nodeList) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
        return root;
    }
}
package leetCode.dailyQuestion.DeepestLeavesSum;

import leetCode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.add(root);
        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            res = 0;
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                res += pop.val;
                if (pop.left != null) {
                    deque.add(pop.left);
                }
                if (pop.right != null) {
                    deque.add(pop.right);
                }
            }
        }
        return res;
    }

}
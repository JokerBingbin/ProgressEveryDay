package leetCode.dailyQuestion.PathSumIII;

import java.util.HashMap;
import leetCode.tree.TreeNode;

public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> prefix = new HashMap<>();

        prefix.put(0,1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode node, HashMap<Integer, Integer> prefix, int cur, int target) {
        if (node == null) {
            return 0;
        }

        int ret = 0;
        cur += node.val;
        ret += prefix.getOrDefault(cur - target, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        ret += dfs(node.left, prefix, cur, target);
        ret += dfs(node.right, prefix, cur, target);
        prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);
        return ret;
    }
}

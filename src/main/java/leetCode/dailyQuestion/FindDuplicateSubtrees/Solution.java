package leetCode.dailyQuestion.FindDuplicateSubtrees;

import leetCode.tree.TreeNode;

import java.util.*;

public class Solution {


    private Map<String, TreeNode> map = new HashMap<>();
    private Set<TreeNode> set = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(set);
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        String s = root.val +
                "(" +
                dfs(root.left) +
                ")(" +
                dfs(root.right) +
                ")";
        if (!map.containsKey(s)) {
            map.put(s, root);
        } else {
            set.add(map.get(s));
        }
        return s;
    }


}

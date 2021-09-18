package leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和II
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 */
public class PathSumII {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    /**
     * 主要思路还是递归 参照PathSum的思路。
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        travel(root, targetSum);
        return res;
    }

    public void travel(TreeNode node, int targetSum) {
        if (node == null) {
           return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == targetSum) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        travel(node.left, targetSum - node.val);
        travel(node.right, targetSum - node.val);
        list.remove(list.size() - 1);
    }

}

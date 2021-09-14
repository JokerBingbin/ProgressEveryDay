package leetCode.tree;

/**
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 */
public class SortedArrayToBST {


    /**
     * 二叉搜索树有一个重要的特点：中序遍历是一个递增数列。
     * 题目给我们的也是一个递增数列，那么这道题就转换成了把中序遍历的数组转换成二叉树
     * 这样的结果显然不唯一，每一个数都可以作为根节点。
     * 题目有限制高度平衡条件，结果依然不唯一,这里只用一种解法
     * 取中间的数作为根节点，像两边生长。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return growUp(nums, 0, nums.length - 1);
    }

    public TreeNode growUp(int[] nums, int left, int right) {
        if (left > right) {
           return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = growUp(nums, left, mid - 1);
        root.right = growUp(nums, mid + 1 ,right);
        return root;
    }
}

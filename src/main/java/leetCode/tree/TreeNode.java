package leetCode.tree;

/**
 * 二叉树的结点类，本包下的所有算法都可以直接使用该类
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() { }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode leftChild, TreeNode rightChild) {
        this.val = val;
        this.left = leftChild;
        this.right = rightChild;
    }

}

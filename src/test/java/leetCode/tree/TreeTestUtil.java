package leetCode.tree;

public class TreeTestUtil {

    public static TreeNode getTree() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        return new TreeNode(3, left, right);
    }
}

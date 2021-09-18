package leetCode.tree;

import java.util.List;
import leetCode.LinkedList.ConstructBinaryTreeFromPreorderAndInorderTraversal;
import org.junit.Test;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    @Test
    public void testBuildTree() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        ConstructBinaryTreeFromPreorderAndInorderTraversal builder = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode treeNode = builder.buildTree(preorder, inorder);
        PreorderTraversal traversal = new PreorderTraversal();
        List<Integer> integers = traversal.preorderTraversal(treeNode);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
}

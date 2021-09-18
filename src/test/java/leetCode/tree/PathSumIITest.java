package leetCode.tree;

import java.util.List;
import org.junit.Test;

public class PathSumIITest {

    @Test
    public void testPathSum() {
        TreeNode root = new TreeNode(5);
        TreeNode temp = root;
        temp.left = new TreeNode(4);;
        temp.right = new TreeNode(8);
        temp = temp.left;
        temp.left = new TreeNode(11);
        temp = temp.left;
        temp.left = new TreeNode(7);
        temp.right = new TreeNode(2);
        temp = root.right;
        temp.left = new TreeNode(13);
        temp.right = new TreeNode(4);
        temp = temp.right;
        temp.left = new TreeNode(5);
        temp.right = new TreeNode(1);
        PathSumII sum = new PathSumII();
        List<List<Integer>> res = sum.pathSum(root, 22);
        for (List<Integer> list : res) {
            for (int a : list) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }


}

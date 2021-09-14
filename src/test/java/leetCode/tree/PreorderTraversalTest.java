package leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PreorderTraversalTest {

    private TreeNode testRoot = TreeTestUtil.getTree();
    private PreorderTraversal solution = new PreorderTraversal();

    @Test
    public void testTraversalWithStack() {
        List<Integer> res = new ArrayList<Integer>();
        solution.traversalWithStack(testRoot, res);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(3);
        expected.add(1);
        expected.add(2);
        Assert.assertEquals(expected, res);

    }
}

package leetCode.LinkedList;


import java.util.HashMap;
import java.util.Map;
import leetCode.tree.TreeNode;

/**
 * 根据前序和中序遍历序列构造二叉树
 *
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 * 这是我在字节一面的时候遇到的算法题，当时虽然最后做出来的，但是在找思路的时候花的时间比较长。
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> indexMap;

    /**
     * 先用我在面试中的思路做一遍。
     * 对于前序遍历，数组的顺序是  根结点，左子树， 右子树
     * 对于中序遍历，数组的顺序是  左子树，根结点， 右子树
     * 所以我们可以用递归的方式，定位中序遍历中根结点的位置，然后构建二叉树。
     * 为了能更快地遍历根结点的位置，我们可以用先遍历一次，用哈希表存储各个点的位置。
     *
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeByRecursion(preorder, inorder, 0, n-1, 0, n-1);
    }

    public TreeNode buildTreeByRecursion(int[] preorder, int[] inorder,int preorderLeft, int preorderRight,
            int inorderLeft, int inorderRight) {
        if(preorderLeft > preorderRight) {
            return  null;
        }
        int inorderRoot = indexMap.get(preorder[preorderLeft]);
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        root.left = buildTreeByRecursion(preorder, inorder, preorderLeft + 1, preorderLeft + inorderRoot - inorderLeft, inorderLeft, inorderRoot - 1);
        root.right = buildTreeByRecursion(preorder, inorder, preorderLeft + inorderRoot - inorderLeft + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }
    

}

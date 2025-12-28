package LeetCode;

import javax.swing.tree.TreeNode;

public class BinaryTreeMaximumPathSum {

    class Solution {
    int max = Integer.MIN_VALUE;

    public int count(TreeNode root) {
        if (root == null) return 0;
        int leftChild = Math.max(0, count(root.left));
        int rightChild = Math.max(0, count(root.right));

        max = Math.max(max, leftChild + rightChild + root.val);

        return root.val + Math.max(leftChild, rightChild);
    }

    public int maxPathSum(TreeNode root) {
        count(root);
        return max;
    }
}

}

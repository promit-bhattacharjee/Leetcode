package LeetCode;

import javax.swing.tree.TreeNode;

public class validateBinarySearchTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean validate(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) {
                return true;
            }
            if (min!=null && root.val <= min.val) {
                return false;
            }
            if (max!=null && root.val >= max.val) {
                return false;
            }
            return validate(root.left, min, root) && validate(root.right, root, max);
        }

        public boolean isValidBST(TreeNode root) {

            return validate(root, nu', root.right);
        }
    }

public static void main(String[] args) {
    Solution sol = new validateBinarySearchTree().new Solution();
    TreeNode root = [2,1,3];
    
}
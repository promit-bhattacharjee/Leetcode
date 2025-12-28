package LeetCode;

import Tree.DiameterOfTree.BinaryTree.Tree;

public class InvertBinaryTree {
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
        TreeNode helper(TreeNode root){
            if(root==null) return null;

            TreeNode right=helper(root.right);
            TreeNode left=helper(root.left);

            root.left=right;
            root.right=left;

            return root;
        }
        public TreeNode invertTree(TreeNode root) {
            if(root==null) return null;
            return helper(root); 
        }
    }
}

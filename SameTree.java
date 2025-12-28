package LeetCode;

public class SameTree {

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
        boolean helper(TreeNode p, TreeNode   q){
            if (p==null && q==null) return true;
            if(p==null ) return false;
            if (q==null) return false; 
            if(p.val != q.val) return false;
            return helper(p.left, q.left) && helper(p.right, q.right);

        }
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(q==null && p==null) return true;
            if(q==null || p==null) return false;
            return helper(p,q);
        }
    }
}

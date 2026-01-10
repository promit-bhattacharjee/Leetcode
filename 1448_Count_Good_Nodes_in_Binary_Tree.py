# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if not root: return 0
        count=0
        def dfs(node,parent_val):
            if not node: return 0
            res=1 if node.val>=parent_val else 0
            parent_val=max(parent_val,node.val)
            res+=dfs(node.left,parent_val)
            res+=dfs(node.right,parent_val)
            return res
        return dfs(root,root.val)
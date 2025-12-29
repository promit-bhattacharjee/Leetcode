# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def path_finder(self, root, target_val, path):
        if not root:
            return False
        path.append(root)
        if root.val == target_val:
            return True
        
        # Search in children
        if (self.path_finder(root.left, target_val, path) or 
            self.path_finder(root.right, target_val, path)):
            return True
        
        path.pop()
        return False

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        path1 = []
        path2 = []
        self.path_finder(root, p.val, path1)
        self.path_finder(root, q.val, path2)
        
        i = 0
        last_common = None
        while i < len(path1) and i < len(path2):
            if path1[i] == path2[i]:
                last_common = path1[i]
                i += 1
            else:
                break
                
        return last_common
# approach 2
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return root
        def helper(node):
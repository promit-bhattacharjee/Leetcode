class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


import collections
class Solution:

    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root is None: return []
        q=collections.deque([root])
        dept=0
        while q:
            qlen=len(q)
            for _ in range(qlen):
                cur = q.popleft()
                if cur.left is not None:
                    q.append(cur.left)
                if cur.right is not None: 
                    q.append(cur.right)
            dept+=1;
        return dept 
            
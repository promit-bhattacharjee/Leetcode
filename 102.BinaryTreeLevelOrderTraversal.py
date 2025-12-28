import collections


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    from collections import deque
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        results=[]

        q=collections.deque([current])
        while q:
           qlen=len(q)
           level=[]

           for _ in range(qlen):
                temp=q.popleft()
                if temp:
                    level.append(temp.val)
                    if temp.left is not None:
                        q.append(temp.left)
                    if temp.right is not None:
                        q.append(temp.right)
                results.append(level)
        return results
            
                   
           
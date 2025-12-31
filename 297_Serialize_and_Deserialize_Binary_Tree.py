# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        if not root: return ""
        from collections import deque
        q=deque([root])
        result=[]
        while q:
            cur=q.popleft()
            if cur:
                result.append(str(cur.val))
                q.append(cur.left)
                q.append(cur.right)
            else: 
                result.append("N")
        return ",".join(result)
    def deserialize(self, data):
        if not data : return None
        list_str=data.split(',')
        from collections import deque
        q=deque()
        root=TreeNode(int(list_str[0]))
        q=deque([root])
        index=1
        while q:
            cur=q.popleft()

            if list_str[index] !="N":
                cur.left=TreeNode(int(list_str[index]))
                q.append(cur.left)
            index+=1
            if list_str[index] !="N":
                cur.right=TreeNode(int(list_str[index]))
                q.append(cur.right)
            index+=1
        return root

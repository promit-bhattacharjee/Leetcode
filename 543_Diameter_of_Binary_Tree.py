# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def diameterOfBinaryTree(self, root):
        self.max_d=0
        def dept(node):
            if not node:
                return 0
            
            left=dept(node.left)
            right=dept(node.right)
            self.max_d=max(self.max_d,left+right)
            return max(right,left)+1

        dept(root)
        return self.max_d


def main():
    # 1. Create the nodes
    node5 = TreeNode(5)
    node2 = TreeNode(2)
    # node1 = TreeNode(1)
    # node3 = TreeNode(3)

    # 2. Connect the nodes (Manual tree construction)
    node5.left = node2
    # node2.left = node1
    # node2.right = node3

    # 3. Run the solution using the root (node5)
    sol = Solution()
    result = sol.diameterOfBinaryTree(node5)
    print(f"The diameter of the tree is: {result}")

if __name__ == "__main__":
    main()



        
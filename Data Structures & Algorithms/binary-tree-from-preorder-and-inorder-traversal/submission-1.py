# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder, inorder):
        inorder_map = {v: i for i, v in enumerate(inorder)}
        self.idx = 0

        def dfs(left, right):
            if left > right:
                return None

            root_val = preorder[self.idx]
            self.idx += 1

            root = TreeNode(root_val)
            mid = inorder_map[root_val]

            root.left = dfs(left, mid - 1)
            root.right = dfs(mid + 1, right)

            return root

        return dfs(0, len(inorder) - 1)

            
            
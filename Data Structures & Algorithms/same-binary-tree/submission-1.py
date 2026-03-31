# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p, q):
        # both null
        if not p and not q:
            return True

        # one null or values differ
        if not p or not q or p.val != q.val:
            return False

        # check left and right
        return (self.isSameTree(p.left, q.left) and
                self.isSameTree(p.right, q.right))
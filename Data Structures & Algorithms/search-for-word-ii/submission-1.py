class TrieNode:

    def __init__(self):
        self.children = {}
        self.word = False


class Solution:

    def findWords(self, board, words):

        root = TrieNode()

        for word in words:

            node = root

            for char in word:

                if char not in node.children:
                    node.children[char] = TrieNode()

                node = node.children[char]

            node.word = word

        rows = len(board)
        cols = len(board[0])

        result = []

        def dfs(r, c, node):

            if (r < 0 or c < 0 or
                r >= rows or c >= cols):
                return

            char = board[r][c]

            if char == "#" or char not in node.children:
                return

            node = node.children[char]

            if node.word:
                result.append(node.word)
                node.word = False

            board[r][c] = "#"

            dfs(r + 1, c, node)
            dfs(r - 1, c, node)
            dfs(r, c + 1, node)
            dfs(r, c - 1, node)

            board[r][c] = char

        for r in range(rows):
            for c in range(cols):
                dfs(r, c, root)

        return result
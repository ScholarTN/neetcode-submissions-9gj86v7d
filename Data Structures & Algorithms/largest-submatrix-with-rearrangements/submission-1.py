class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        for i in range(1, m):
            for j in range(n):
                if matrix[i][j]:
                    matrix[i][j] += matrix[i - 1][j]

        ans = 0

        for row in matrix:
            heights = sorted(row)

            for i, h in enumerate(heights):
                width = n - i
                ans = max(ans, h * width)

        return ans
class Solution:

    def generateParenthesis(self, n):

        result = []

        def backtrack(openN, closeN, path):

            if openN == closeN == n:
                result.append(path)
                return

            if openN < n:
                backtrack(openN + 1,
                          closeN,
                          path + "(")

            if closeN < openN:
                backtrack(openN,
                          closeN + 1,
                          path + ")")

        backtrack(0, 0, "")

        return result
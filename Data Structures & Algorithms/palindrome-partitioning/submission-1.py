class Solution:

    def partition(self, s):

        result = []

        def isPalindrome(string):

            left = 0
            right = len(string) - 1

            while left < right:

                if string[left] != string[right]:
                    return False

                left += 1
                right -= 1

            return True

        def backtrack(start, path):

            if start == len(s):
                result.append(path[:])
                return

            for end in range(start + 1, len(s) + 1):

                substring = s[start:end]

                if isPalindrome(substring):

                    path.append(substring)

                    backtrack(end, path)

                    path.pop()

        backtrack(0, [])

        return result
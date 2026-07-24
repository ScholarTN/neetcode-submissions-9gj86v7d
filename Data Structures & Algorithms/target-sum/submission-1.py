class Solution:

    def findTargetSumWays(self, nums, target):

        memo = {}

        def dfs(i, total):

            if i == len(nums):
                return 1 if total == target else 0

            if (i, total) in memo:
                return memo[(i, total)]

            positive = dfs(i + 1, total + nums[i])

            negative = dfs(i + 1, total - nums[i])

            memo[(i, total)] = positive + negative

            return memo[(i, total)]

        return dfs(0, 0)
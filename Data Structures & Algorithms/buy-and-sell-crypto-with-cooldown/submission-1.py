class Solution:

    def maxProfit(self, prices):

        memo = {}

        def dfs(i, buying):

            if i >= len(prices):
                return 0

            if (i, buying) in memo:
                return memo[(i, buying)]

            if buying:

                buy = -prices[i] + dfs(i + 1, False)

                skip = dfs(i + 1, True)

                memo[(i, buying)] = max(buy, skip)

            else:

                sell = prices[i] + dfs(i + 2, True)

                hold = dfs(i + 1, False)

                memo[(i, buying)] = max(sell, hold)

            return memo[(i, buying)]

        return dfs(0, True)
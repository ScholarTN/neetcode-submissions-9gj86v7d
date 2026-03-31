class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        first = 0
        second = 0

        for i in range(0,len(cost)):
            curr = cost[i]+min(first,second)
            first = second
            second = curr
        return min(first,second)
        
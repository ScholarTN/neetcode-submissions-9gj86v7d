from bisect import bisect_left

class Solution:
    def lengthOfLIS(self, nums):
        tails = []

        for num in nums:
            idx = bisect_left(tails, num)

            if idx == len(tails):
                tails.append(num)
            else:
                tails[idx] = num

        return len(tails)
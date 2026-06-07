class Solution:

    def rob(self, nums):

        rob1 = 0
        rob2 = 0

        for num in nums:

            temp = max(num + rob1,
                       rob2)

            rob1 = rob2
            rob2 = temp

        return rob2
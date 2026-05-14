class Solution:
    def leastInterval(self, tasks, n):

        count = [0] * 26

        for task in tasks:
            count[ord(task) - ord('A')] += 1

        maxFreq = max(count)

        maxCount = 0

        for num in count:
            if num == maxFreq:
                maxCount += 1

        return max(len(tasks),
                   (maxFreq - 1) * (n + 1) + maxCount)
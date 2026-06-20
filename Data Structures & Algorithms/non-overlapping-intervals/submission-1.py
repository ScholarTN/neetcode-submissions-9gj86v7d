class Solution:
    def eraseOverlapIntervals(self, intervals):
        intervals.sort(key=lambda x: x[1])

        end = intervals[0][1]
        count = 0

        for start, finish in intervals[1:]:
            if start < end:
                count += 1
            else:
                end = finish

        return count
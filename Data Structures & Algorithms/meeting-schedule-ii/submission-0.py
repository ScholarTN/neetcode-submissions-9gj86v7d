"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""



class Solution:
    def minMeetingRooms(self, intervals):
        if not intervals:
            return 0

        intervals.sort(key=lambda x: x.start)

        heap = []

        for interval in intervals:
            if heap and interval.start >= heap[0]:
                heapq.heappop(heap)

            heapq.heappush(heap, interval.end)

        return len(heap)
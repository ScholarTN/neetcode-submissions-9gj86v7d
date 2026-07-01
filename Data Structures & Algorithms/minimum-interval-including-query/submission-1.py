class Solution:

    def minInterval(self, intervals, queries):

        intervals.sort()

        sortedQueries = sorted((q, i) for i, q in enumerate(queries))

        heap = []

        answer = [-1] * len(queries)

        i = 0

        for query, index in sortedQueries:

            while i < len(intervals) and intervals[i][0] <= query:

                left, right = intervals[i]

                heapq.heappush(
                    heap,
                    (right - left + 1,
                     right)
                )

                i += 1

            while heap and heap[0][1] < query:

                heapq.heappop(heap)

            if heap:

                answer[index] = heap[0][0]

        return answer
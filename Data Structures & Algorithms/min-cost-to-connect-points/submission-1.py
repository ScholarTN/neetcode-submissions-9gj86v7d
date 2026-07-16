class Solution:

    def minCostConnectPoints(self, points):

        n = len(points)

        visited = set()

        heap = [(0, 0)]

        cost = 0

        while len(visited) < n:

            weight, node = heapq.heappop(heap)

            if node in visited:
                continue

            visited.add(node)

            cost += weight

            x1, y1 = points[node]

            for nei in range(n):

                if nei not in visited:

                    x2, y2 = points[nei]

                    dist = abs(x1 - x2) + abs(y1 - y2)

                    heapq.heappush(
                        heap,
                        (dist, nei)
                    )

        return cost
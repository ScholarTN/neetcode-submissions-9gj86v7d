class Solution:

    def networkDelayTime(self, times, n, k):

        graph = defaultdict(list)

        for u, v, w in times:
            graph[u].append((v, w))

        heap = [(0, k)]

        visited = set()

        answer = 0

        while heap:

            time, node = heapq.heappop(heap)

            if node in visited:
                continue

            visited.add(node)

            answer = max(answer, time)

            for nei, weight in graph[node]:

                if nei not in visited:

                    heapq.heappush(
                        heap,
                        (time + weight, nei)
                    )

        if len(visited) == n:
            return answer

        return -1
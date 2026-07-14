class Solution:

    def findCheapestPrice(self, n, flights, src, dst, k):

        graph = defaultdict(list)

        for u, v, price in flights:
            graph[u].append((v, price))

        prices = [float("inf")] * n
        prices[src] = 0

        queue = deque([(src, 0)])

        stops = 0

        while queue and stops <= k:

            size = len(queue)

            temp = prices[:]

            for _ in range(size):

                city, cost = queue.popleft()

                for nei, price in graph[city]:

                    if cost + price < temp[nei]:

                        temp[nei] = cost + price

                        queue.append((nei, cost + price))

            prices = temp

            stops += 1

        return -1 if prices[dst] == float("inf") else prices[dst]
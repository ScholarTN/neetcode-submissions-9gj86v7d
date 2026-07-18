

class Solution:

    def findItinerary(self, tickets):

        graph = defaultdict(list)

        tickets.sort(reverse=True)

        for src, dst in tickets:
            graph[src].append(dst)

        itinerary = []

        def dfs(airport):

            while graph[airport]:
                next_airport = graph[airport].pop()
                dfs(next_airport)

            itinerary.append(airport)

        dfs("JFK")

        return itinerary[::-1]
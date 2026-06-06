class Solution:

    def validTree(self, n, edges):

        if len(edges) != n - 1:
            return False

        graph = {i: [] for i in range(n)}

        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)

        visit = set()

        def dfs(node, parent):

            if node in visit:
                return False

            visit.add(node)

            for neighbor in graph[node]:

                if neighbor == parent:
                    continue

                if not dfs(neighbor, node):
                    return False

            return True

        if not dfs(0, -1):
            return False

        return len(visit) == n
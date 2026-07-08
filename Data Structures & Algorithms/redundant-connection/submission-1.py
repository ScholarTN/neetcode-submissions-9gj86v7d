class Solution:

    def findRedundantConnection(self, edges):

        parent = [i for i in range(len(edges) + 1)]
        rank = [1] * (len(edges) + 1)

        def find(x):

            while x != parent[x]:
                parent[x] = parent[parent[x]]
                x = parent[x]

            return x

        def union(a, b):

            pa = find(a)
            pb = find(b)

            if pa == pb:
                return False

            if rank[pa] > rank[pb]:
                parent[pb] = pa
                rank[pa] += rank[pb]

            else:
                parent[pa] = pb
                rank[pb] += rank[pa]

            return True

        for u, v in edges:

            if not union(u, v):
                return [u, v]
class Solution:

    def swimInWater(self, grid):

        n = len(grid)

        visited = set()

        heap = [(grid[0][0], 0, 0)]

        directions = [
            (1,0),
            (-1,0),
            (0,1),
            (0,-1)
        ]

        while heap:

            time, r, c = heapq.heappop(heap)

            if (r, c) in visited:
                continue

            visited.add((r, c))

            if r == n - 1 and c == n - 1:
                return time

            for dr, dc in directions:

                nr = r + dr
                nc = c + dc

                if (0 <= nr < n and
                    0 <= nc < n and
                    (nr, nc) not in visited):

                    heapq.heappush(
                        heap,
                        (
                            max(time, grid[nr][nc]),
                            nr,
                            nc
                        )
                    )
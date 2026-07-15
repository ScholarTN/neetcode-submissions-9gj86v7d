class Solution {

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<int[]> heap =
                new PriorityQueue<>(
                        (a, b) -> a[0] - b[0]);

        boolean[][] visited =
                new boolean[n][n];

        heap.offer(new int[]{
                grid[0][0],
                0,
                0
        });

        int[][] directions = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while (!heap.isEmpty()) {

            int[] current = heap.poll();

            int time = current[0];
            int r = current[1];
            int c = current[2];

            if (visited[r][c]) {
                continue;
            }

            visited[r][c] = true;

            if (r == n - 1 &&
                c == n - 1) {

                return time;
            }

            for (int[] d : directions) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 &&
                    nc >= 0 &&
                    nr < n &&
                    nc < n &&
                    !visited[nr][nc]) {

                    heap.offer(new int[]{
                            Math.max(
                                    time,
                                    grid[nr][nc]),
                            nr,
                            nc
                    });
                }
            }
        }

        return -1;
    }
}
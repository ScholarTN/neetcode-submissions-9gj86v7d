

class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> heap =
                new PriorityQueue<>(
                        (a, b) -> a[0] - b[0]);

        heap.offer(new int[]{0, 0});

        int cost = 0;
        int edges = 0;

        while (edges < n) {

            int[] current = heap.poll();

            int weight = current[0];
            int node = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            cost += weight;

            edges++;

            int x1 = points[node][0];
            int y1 = points[node][1];

            for (int nei = 0; nei < n; nei++) {

                if (!visited[nei]) {

                    int x2 = points[nei][0];
                    int y2 = points[nei][1];

                    int dist =
                            Math.abs(x1 - x2)
                            + Math.abs(y1 - y2);

                    heap.offer(
                            new int[]{
                                    dist,
                                    nei
                            });
                }
            }
        }

        return cost;
    }
}
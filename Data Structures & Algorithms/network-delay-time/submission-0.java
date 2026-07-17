class Solution {

    public int networkDelayTime(int[][] times,
                                int n,
                                int k) {

        HashMap<Integer, ArrayList<int[]>> graph =
                new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : times) {

            graph.get(edge[0]).add(
                    new int[]{
                            edge[1],
                            edge[2]
                    });
        }

        PriorityQueue<int[]> heap =
                new PriorityQueue<>(
                        (a, b) -> a[0] - b[0]);

        heap.offer(new int[]{
                0,
                k
        });

        HashSet<Integer> visited =
                new HashSet<>();

        int answer = 0;

        while (!heap.isEmpty()) {

            int[] current = heap.poll();

            int time = current[0];
            int node = current[1];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);

            answer = Math.max(answer, time);

            for (int[] next :
                    graph.get(node)) {

                int nei = next[0];
                int weight = next[1];

                if (!visited.contains(nei)) {

                    heap.offer(
                            new int[]{
                                    time + weight,
                                    nei
                            });
                }
            }
        }

        if (visited.size() == n) {
            return answer;
        }

        return -1;
    }
}
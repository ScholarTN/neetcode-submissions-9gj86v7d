class Solution {

    public int countComponents(int n, int[][] edges) {

        List<Integer>[] graph =
                new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        HashSet<Integer> visit =
                new HashSet<>();

        int components = 0;

        for (int node = 0; node < n; node++) {

            if (!visit.contains(node)) {

                components++;

                dfs(node,
                    graph,
                    visit);
            }
        }

        return components;
    }

    private void dfs(int node,
                     List<Integer>[] graph,
                     HashSet<Integer> visit) {

        if (visit.contains(node)) {
            return;
        }

        visit.add(node);

        for (int neighbor : graph[node]) {

            dfs(neighbor,
                graph,
                visit);
        }
    }
}
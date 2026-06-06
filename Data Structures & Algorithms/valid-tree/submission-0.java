class Solution {

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

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

        if (!dfs(0, -1, graph, visit)) {
            return false;
        }

        return visit.size() == n;
    }

    private boolean dfs(int node,
                        int parent,
                        List<Integer>[] graph,
                        HashSet<Integer> visit) {

        if (visit.contains(node)) {
            return false;
        }

        visit.add(node);

        for (int neighbor : graph[node]) {

            if (neighbor == parent) {
                continue;
            }

            if (!dfs(neighbor,
                     node,
                     graph,
                     visit)) {

                return false;
            }
        }

        return true;
    }
}
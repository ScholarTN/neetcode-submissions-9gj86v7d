class Solution {

    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {

            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[0];
    }

    private int find(int x) {

        while (x != parent[x]) {

            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    private boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return false;
        }

        if (rank[pa] > rank[pb]) {

            parent[pb] = pa;
            rank[pa] += rank[pb];
        }

        else {

            parent[pa] = pb;
            rank[pb] += rank[pa];
        }

        return true;
    }
}
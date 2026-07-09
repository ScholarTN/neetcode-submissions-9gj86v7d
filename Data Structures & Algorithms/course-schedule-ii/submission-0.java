class Solution {

    public int[] findOrder(int numCourses,
                           int[][] prerequisites) {

        HashMap<Integer, ArrayList<Integer>> graph =
                new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[0]).add(p[1]);
        }

        HashMap<Integer, Boolean> visit =
                new HashMap<>();

        ArrayList<Integer> order =
                new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {

            if (dfs(i, graph, visit, order)) {
                return new int[0];
            }
        }

        int[] ans = new int[order.size()];

        for (int i = 0; i < order.size(); i++) {
            ans[i] = order.get(i);
        }

        return ans;
    }

    private boolean dfs(
            int course,
            HashMap<Integer, ArrayList<Integer>> graph,
            HashMap<Integer, Boolean> visit,
            ArrayList<Integer> order) {

        if (visit.containsKey(course)) {
            return visit.get(course);
        }

        visit.put(course, true);

        for (int pre : graph.get(course)) {

            if (dfs(pre,
                    graph,
                    visit,
                    order)) {

                return true;
            }
        }

        visit.put(course, false);

        graph.get(course).clear();

        order.add(course);

        return false;
    }
}

class Solution {

    public boolean canFinish(int numCourses,
                             int[][] prerequisites) {

        List<Integer>[] prereq =
                new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            prereq[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            prereq[p[0]].add(p[1]);
        }

        HashSet<Integer> visitSet =
                new HashSet<>();

        for (int course = 0;
             course < numCourses;
             course++) {

            if (!dfs(course,
                     prereq,
                     visitSet)) {

                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course,
                        List<Integer>[] prereq,
                        HashSet<Integer> visitSet) {

        if (visitSet.contains(course)) {
            return false;
        }

        if (prereq[course].isEmpty()) {
            return true;
        }

        visitSet.add(course);

        for (int pre : prereq[course]) {

            if (!dfs(pre,
                     prereq,
                     visitSet)) {

                return false;
            }
        }

        visitSet.remove(course);

        prereq[course].clear();

        return true;
    }
}
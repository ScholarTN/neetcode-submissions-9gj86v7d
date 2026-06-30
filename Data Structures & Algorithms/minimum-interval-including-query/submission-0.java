class Solution {

    public int[] minInterval(int[][] intervals,
                             int[] queries) {

        Arrays.sort(intervals,
                (a, b) -> a[0] - b[0]);

        int[][] sortedQueries =
                new int[queries.length][2];

        for (int i = 0;
             i < queries.length;
             i++) {

            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,
                (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> heap =
                new PriorityQueue<>(
                        (a, b) -> a[0] - b[0]);

        int[] ans =
                new int[queries.length];

        Arrays.fill(ans, -1);

        int i = 0;

        for (int[] q : sortedQueries) {

            int query = q[0];
            int index = q[1];

            while (i < intervals.length &&
                   intervals[i][0] <= query) {

                int left = intervals[i][0];
                int right = intervals[i][1];

                heap.offer(new int[]{
                        right - left + 1,
                        right
                });

                i++;
            }

            while (!heap.isEmpty() &&
                   heap.peek()[1] < query) {

                heap.poll();
            }

            if (!heap.isEmpty()) {

                ans[index] = heap.peek()[0];
            }
        }

        return ans;
    }
}
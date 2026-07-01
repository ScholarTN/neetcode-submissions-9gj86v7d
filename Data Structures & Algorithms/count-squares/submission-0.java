

class CountSquares {
    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> yMap = points.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if (!points.containsKey(x)) {
            return 0;
        }

        int ans = 0;

        Map<Integer, Integer> yMap = points.get(x);

        for (int col : points.keySet()) {
            if (col == x) {
                continue;
            }

            int d = col - x;

            ans += yMap.getOrDefault(y + d, 0) * points.get(col).getOrDefault(y, 0)
                * points.get(col).getOrDefault(y + d, 0);

            ans += yMap.getOrDefault(y - d, 0) * points.get(col).getOrDefault(y, 0)
                * points.get(col).getOrDefault(y - d, 0);
        }

        return ans;
    }
}


class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        for (int c = 0; c < cols; c++) {

            dfs(0, c, pacific, heights[0][c], heights);
            dfs(rows - 1, c, atlantic,
                heights[rows - 1][c], heights);
        }

        for (int r = 0; r < rows; r++) {

            dfs(r, 0, pacific,
                heights[r][0], heights);

            dfs(r, cols - 1, atlantic,
                heights[r][cols - 1], heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                String key = r + "," + c;

                if (pacific.contains(key)
                        && atlantic.contains(key)) {

                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r,
                     int c,
                     Set<String> visit,
                     int prevHeight,
                     int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        String key = r + "," + c;

        if (r < 0 || c < 0 ||
            r >= rows || c >= cols ||
            visit.contains(key) ||
            heights[r][c] < prevHeight) {

            return;
        }

        visit.add(key);

        dfs(r + 1, c, visit,
            heights[r][c], heights);

        dfs(r - 1, c, visit,
            heights[r][c], heights);

        dfs(r, c + 1, visit,
            heights[r][c], heights);

        dfs(r, c - 1, visit,
            heights[r][c], heights);
    }
}
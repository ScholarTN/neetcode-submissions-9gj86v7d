class Solution {

    private int[][] memo;

    private int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public int longestIncreasingPath(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        memo = new int[rows][cols];

        int answer = 0;

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                answer = Math.max(
                        answer,
                        dfs(matrix, r, c)
                );
            }
        }

        return answer;
    }

    private int dfs(int[][] matrix,
                    int r,
                    int c) {

        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int longest = 1;

        for (int[] d : directions) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 &&
                nr < rows &&
                nc >= 0 &&
                nc < cols &&
                matrix[nr][nc] > matrix[r][c]) {

                longest = Math.max(
                        longest,
                        1 + dfs(matrix, nr, nc)
                );
            }
        }

        memo[r][c] = longest;

        return longest;
    }
}
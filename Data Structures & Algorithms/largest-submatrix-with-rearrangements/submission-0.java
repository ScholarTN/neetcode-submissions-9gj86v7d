class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            int[] heights = matrix[i].clone();
            java.util.Arrays.sort(heights);

            for (int j = 0; j < n; j++) {
                int height = heights[j];
                int width = n - j;
                ans = Math.max(ans, height * width);
            }
        }

        return ans;
    }
}
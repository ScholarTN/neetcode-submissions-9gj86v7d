
class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        backtrack(0,
                  n,
                  board,
                  cols,
                  posDiag,
                  negDiag,
                  result);

        return result;
    }

    private void backtrack(int row,
                           int n,
                           char[][] board,
                           Set<Integer> cols,
                           Set<Integer> posDiag,
                           Set<Integer> negDiag,
                           List<List<String>> result) {

        if (row == n) {

            List<String> copy = new ArrayList<>();

            for (char[] r : board) {
                copy.add(new String(r));
            }

            result.add(copy);

            return;
        }

        for (int col = 0; col < n; col++) {

            if (cols.contains(col) ||
                posDiag.contains(row + col) ||
                negDiag.contains(row - col)) {

                continue;
            }

            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);

            board[row][col] = 'Q';

            backtrack(row + 1,
                      n,
                      board,
                      cols,
                      posDiag,
                      negDiag,
                      result);

            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);

            board[row][col] = '.';
        }
    }
}
import java.util.*;

class Solution {
    List<List<String>> results;
    char[][] board;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.results = new ArrayList<>();
        this.n = n;
        this.board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0);
        return results;
    }

    private void backtrack(int row) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            results.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
}
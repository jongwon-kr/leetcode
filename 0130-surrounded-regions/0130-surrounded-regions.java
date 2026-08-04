import java.util.*;
import java.io.*;

class Solution {

    static int m, n;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        // 가장자리 먼저 체크 후 임시로 다른 문자로 치환한 다음 남아 있는 O를 전부 캡쳐하고 다시 S를 O로 변경
        m = board.length;
        n = board[0].length;

        int j = 0, k = n - 1;
        for (int i = 0; i < m; i++) {
            if (board[i][j] == 'O') {
                dfs(i, j, board);
            }

            if (board[i][k] == 'O') {
                dfs(i, k, board);
            }
        }

        int o = 0, p = m - 1;
        for (int u = 0; u < n; u++) {
            if (board[o][u] == 'O') {
                dfs(o, u, board);
            }

            if (board[p][u] == 'O') {
                dfs(p, u, board);
            }
        }

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                if (board[a][b] == 'O') {
                    board[a][b] = 'X';
                }
            }
        }

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                if (board[a][b] == 'S') {
                    board[a][b] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {

        if (i >= m || i < 0 || j >= n || j < 0) return;
        if (board[i][j] == 'X' || board[i][j] == 'S') return;

        board[i][j] = 'S';

        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}
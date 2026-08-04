import java.util.*;
import java.io.*;

class Solution {
    static int m, n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        m = board.length;
        n = board[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'S';
                q.offer(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = 'S';
                q.offer(new int[]{i, n - 1});
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'S';
                q.offer(new int[]{0, j});
            }
            if (board[m - 1][j] == 'O') {
                board[m - 1][j] = 'S';
                q.offer(new int[]{m - 1, j});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || board[nx][ny] != 'O') continue;

                board[nx][ny] = 'S';
                q.offer(new int[]{nx, ny});
            }
        }

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                if (board[a][b] == 'O') board[a][b] = 'X';
                else if (board[a][b] == 'S') board[a][b] = 'O';
            }
        }
    }
}
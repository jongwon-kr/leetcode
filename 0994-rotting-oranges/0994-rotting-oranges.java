import java.util.*;

class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int n, m;

    public int orangesRotting(int[][] grid) {
        int answer = 0;
        ArrayDeque<int[]> adq = new ArrayDeque<>();

        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    adq.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!adq.isEmpty()) {
            int[] cur = adq.poll();
            int cx = cur[0];
            int cy = cur[1];
            int minute = grid[cx][cy] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                grid[nx][ny] = minute;
                answer = Math.max(answer, minute);
                adq.offer(new int[]{nx, ny});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        if (answer > 2) {
            return answer - 2;
        }

        return answer;
    }
}
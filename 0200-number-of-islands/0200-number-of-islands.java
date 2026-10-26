import java.util.*;

class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int n, m;

    public int numIslands(char[][] grid) {
        int answer = 0;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    public void bfs(int x, int y, char[][] grid) {
        ArrayDeque<int []> adq = new ArrayDeque<>();
        adq.offer(new int[]{x, y});

        while (!adq.isEmpty()) {
            int[] cur = adq.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || grid[nx][ny] == '0') continue;

                visited[nx][ny] = true;
                adq.offer(new int[]{nx, ny});
            }
        }
    }
}
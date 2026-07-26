import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n = 0, m = 0;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        // 섬 개수
        int cntLand = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않은 육지
                if (!visited[i][j] && grid[i][j] =='1') {
                    bfs(grid, j, i);
                    cntLand++;
                }
            }
        }

        return cntLand;
    }

    public void bfs(char[][] grid, int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
                if (grid[ny][nx] == '0' || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n = 0, m = 0;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // 섬 개수
        int cntLand = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않은 육지
                if (grid[i][j] =='1') {
                    bfs(grid, j, i);
                    cntLand++;
                }
            }
        }

        return cntLand;
    }

    public void bfs(char[][] grid, int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        grid[y][x] = '0';
        q.offer(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
                if (grid[ny][nx] == '0') continue;

                grid[ny][nx] = '0';
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
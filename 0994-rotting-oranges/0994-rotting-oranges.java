import java.util.*;
import java.io.*;

class Solution {

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {

        // 썩은 오렌지가 1분마다 상하좌우로 전파 BFS로 시간 체크하면서 진행
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int cntLive = 0;
        int minutes = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0}); // x, y, distance
                } else if(grid[i][j] == 1) {
                    cntLive++;
                }
            }
        }
        if (cntLive == 0) {
            return 0;
        }
        // bfs
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                if (grid[nx][ny] != 1) continue;

                grid[nx][ny] = 2;
                q.offer(new int[]{nx, ny, cur[2] + 1});
            }
            minutes = Math.max(minutes, cur[2]);
        }
        if (checkLive(grid) != 0) {
            return - 1;
        }
        return minutes;
    }

    public int checkLive(int[][] grid) {
        int cnt = 0;
        for (int[] arr : grid) {
            for (int i : arr) {
                if (i == 1) cnt++;
            }
        }

        return cnt;
    }
}
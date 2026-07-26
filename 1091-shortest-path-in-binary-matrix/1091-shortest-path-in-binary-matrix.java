import java.util.*;
import java.io.*;

class Solution {

    int[] dx = {-1, 1, -1, 1, -1, 1, 0, 0};
    int[] dy = {-1, 1, 1, -1, 0, 0, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        // 8방향 이동 가능 상하좌우, 대각
        // 같은 숫자 타고 가는 거? 길 없으면 -1 반환, 있으면 방문한 셀 개수 반환
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, -1);
        }
        q.offer(new int[]{0, 0, 1});
        dist[0][0] = 1;

        if (grid[0][0] == 1) return -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int d = cur[2] + 1;
                
                if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                if (dist[nx][ny] > -1 || grid[nx][ny] != 0) continue;

                dist[nx][ny] = d;
                q.offer(new int[]{nx, ny, d});
            }
        }

        return dist[m-1][n-1];
    }
}
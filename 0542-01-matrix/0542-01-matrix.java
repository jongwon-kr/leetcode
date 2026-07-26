import java.util.*;
import java.io.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int  m = 0, n = 0;

    public int[][] updateMatrix(int[][] mat) {
        // 모든 셀에 대해서 BFS를 통해서 가장 가까운 0과의 거리를 반환
        ArrayDeque<int[]> q = new ArrayDeque<>();
        m = mat.length;
        n = mat[0].length;
        int[][] result = new int[m][n];
        for (int[] arr : result) {
            Arrays.fill(arr, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i ++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int dist = cur[2] + 1;

                if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                if (result[nx][ny] != -1) continue;
                
                result[nx][ny] = dist;
                q.offer(new int[]{nx, ny, dist});
            }
        }
        return result;
    }
}
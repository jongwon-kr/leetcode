import java.util.*;

class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int n, m;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        visited = new boolean[m][n];
        ArrayDeque<int[]> adq = new ArrayDeque<>();

        // 0을 찾아서 queue에 넣고 1씩 증가시키도록
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    adq.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!adq.isEmpty()) {
            int[] cur = adq.poll();
            int cx = cur[0];
            int cy = cur[1];
            int distance = cur[2] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (mat[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                mat[nx][ny] = distance;
                adq.offer(new int[]{nx, ny, distance});
            }
        }
        return mat;
    }
}
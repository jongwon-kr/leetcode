import java.util.*;
import java.io.*;

class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> answer = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];

        int cx = 0, cy = 0, d = 0;

        for (int i = 0; i < m * n; i++) {
            answer.add(matrix[cy][cx]);
            visited[cy][cx] = true;

            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[ny][nx]) {
                d = (d + 1) % 4;
                nx = cx + dx[d];
                ny = cy + dy[d];
            }

            cx = nx;
            cy = ny;
        }

        return answer;
    }
}
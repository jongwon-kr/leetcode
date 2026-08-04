import java.util.*;

class Solution {

    static boolean[][] vis;
    static int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        // 섬들을 찾고 면적을 계산한 후 최대 면적을 반환
        // 이차원 배열을 순회하면서 땅(1)을 발견하면 dfs후 면적을 반환 한 뒤 최대값으로 갱신
        int maxArea = 0;

        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);  // 최대값 갱신
                }
            }
        }

        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid) {

        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (grid[i][j] == 0 || vis[i][j]) return 0;

        vis[i][j] = true;

        return 1 +
                dfs(i + 1, j, grid) +
                dfs(i - 1, j, grid) +
                dfs(i, j + 1, grid) +
                dfs(i, j - 1, grid);
    }
}
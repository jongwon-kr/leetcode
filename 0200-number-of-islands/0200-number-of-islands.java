import java.io.*;
import java.util.*;

class Solution {
    
    boolean[][] visited;

    public int numIslands(char[][] grid) {

        visited = new boolean[grid.length][grid[0].length];

        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}
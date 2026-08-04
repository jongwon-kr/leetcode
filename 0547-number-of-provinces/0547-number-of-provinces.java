import java.util.*;
import java.io.*;

class Solution {

    static boolean[] vis;

    public int findCircleNum(int[][] isConnected) {
        int answer = 0;

        int n = isConnected.length;
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, n, isConnected);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int curC, int n, int[][] isConnected) {

        vis[curC] = true;

        for (int i = 0; i < n; i++) {
            if (isConnected[curC][i] == 1 && !vis[i]) {
                dfs(i, n, isConnected);
            }
        }
    }
}
import java.util.*;
import java.io.*;

class Solution {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n <= 0) return result;

        // 체크 배열 : 행, 우하대각, 좌하대각
        boolean[] rCheck = new boolean[n];
        boolean[] rbdCheck = new boolean[2 * n];
        boolean[] lbdCheck = new boolean[2 * n];

        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], '.');
        }

        bt(0, n, map, rCheck, rbdCheck, lbdCheck);

        return result;
    }

    private void bt(int row, int n, char[][] map, boolean[] rCheck, boolean[] rbdCheck, boolean[] lbdCheck) {

        if (row == n) { // 종료 조건
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(map[i]));
            }
            result.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            int rbd = row + col;
            int lbd = row - col + n;

            if (rCheck[col] || rbdCheck[rbd] || lbdCheck[lbd]) continue;

            map[row][col] = 'Q';
            rCheck[col] = true;
            rbdCheck[rbd] = true;
            lbdCheck[lbd] = true;

            bt(row + 1, n, map, rCheck, rbdCheck, lbdCheck);

            map[row][col] = '.';
            rCheck[col] = false;
            rbdCheck[rbd] = false;
            lbdCheck[lbd] = false;
        }
    }
}
class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // image[sr][sc]에서 시작하며 인접하는 같은 값들을 color로 채움
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];

        visited[sr][sc] = true;
        q.offer(new int[]{sr, sc});
        int target = image[sr][sc];
        image[sr][sc] = color;
        
        while (!q.isEmpty()) {
            int[] c = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];

                if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                if (image[nx][ny] != target || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                image[nx][ny] = color;
                q.offer(new int[]{nx, ny});
            }
        }

        return image;
    }
}
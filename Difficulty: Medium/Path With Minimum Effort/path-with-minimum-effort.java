class Solution {
    public int minCostPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = 1000000, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(mat, n, m, mid)) {
                ans = mid;
                high = mid - 1; // try smaller max diff
            } else {
                low = mid + 1; // need bigger diff
            }
        }

        return ans;
    }

    private boolean canReach(int[][] mat, int n, int m, int maxDiff) {
        boolean[][] vis = new boolean[n][m];
        java.util.Queue<int[]> q = new java.util.LinkedList<>();

        q.add(new int[]{0, 0});
        vis[0][0] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == n - 1 && y == m - 1) return true;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny]) {
                    int diff = Math.abs(mat[nx][ny] - mat[x][y]);
                    if (diff <= maxDiff) {
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return false;
    }
}

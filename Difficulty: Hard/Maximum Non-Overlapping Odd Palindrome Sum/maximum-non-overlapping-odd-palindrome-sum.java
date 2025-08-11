class Solution {
    public int maxSum(String s) {
        int n = s.length();
        int[] p = oddManacher(s);
        int[] endBest = new int[n];
        for (int c = 0; c < n; c++) {
            int radius = p[c];
            int end = c + radius - 1;
            int len = 2 * radius - 1;
            if (endBest[end] < len) endBest[end] = len;
        }
        for (int i = n - 2; i >= 0; i--) {
            int propagated = endBest[i + 1] - 2;
            if (propagated > endBest[i]) endBest[i] = propagated;
        }
        int[] leftMax = new int[n];
        leftMax[0] = endBest[0];
        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], endBest[i]);
        int[] startBest = new int[n];
        for (int c = 0; c < n; c++) {
            int radius = p[c];
            int start = c - (radius - 1);
            int len = 2 * radius - 1;
            if (startBest[start] < len) startBest[start] = len;
        }
        for (int i = 1; i < n; i++) {
            int propagated = startBest[i - 1] - 2;
            if (propagated > startBest[i]) startBest[i] = propagated;
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = startBest[n - 1];
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], startBest[i]);
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, leftMax[i] + rightMax[i + 1]);
        }
        return ans;
    }

    private int[] oddManacher(String s) {
        int n = s.length();
        int[] p = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; i++) {
            int k = 1;
            if (i <= r) k = Math.min(p[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            p[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }
        return p;
    }
}



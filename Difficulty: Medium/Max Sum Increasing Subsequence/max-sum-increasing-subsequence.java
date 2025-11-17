class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];

        // dp[i] = maximum sum of increasing subsequence ending at index i
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];  // at least the number itself
        }

        int maxSum = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // valid strictly increasing subsequence
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}

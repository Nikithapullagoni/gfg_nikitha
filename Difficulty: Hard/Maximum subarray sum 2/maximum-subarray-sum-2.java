import java.util.*;

class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        long ans = Long.MIN_VALUE;
        
        for (int i = a; i <= n; i++) {
            // Add prefix[i - a] as potential start index
            int idxToAdd = i - a;
            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[idxToAdd]) {
                dq.pollLast();
            }
            dq.addLast(idxToAdd);
            
            // Remove indices out of window size b
            while (!dq.isEmpty() && dq.peekFirst() < i - b) {
                dq.pollFirst();
            }
            
            // Calculate possible answer
            if (!dq.isEmpty()) {
                ans = Math.max(ans, prefix[i] - prefix[dq.peekFirst()]);
            }
        }
        
        return (int) ans;
    }
}

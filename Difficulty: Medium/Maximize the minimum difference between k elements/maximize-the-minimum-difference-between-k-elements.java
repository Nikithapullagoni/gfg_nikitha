import java.util.*;

class Solution {
    public int maxMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 0, high = arr[n - 1] - arr[0], ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean isPossible(int[] arr, int k, int minDiff) {
        int count = 1;
        int lastPicked = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPicked >= minDiff) {
                count++;
                lastPicked = arr[i];
                if (count >= k) return true;
            }
        }
        return false;
    }
}

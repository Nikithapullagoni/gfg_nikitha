class Solution {
    int countFreq(int[] arr, int target) {
        int n = arr.length;

        int first = firstOccurrence(arr, n, target);
        if (first == -1) return 0;

        int last = lastOccurrence(arr, n, target);
        return last - first + 1;
    }

    private int firstOccurrence(int[] arr, int n, int target) {
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int lastOccurrence(int[] arr, int n, int target) {
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}




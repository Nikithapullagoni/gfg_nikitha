class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = (arr[i] > k) ? 1 : -1;
        }
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        int prefixSum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += transformed[i];

            if (prefixSum > 0) {
                maxLen = i + 1; 
            } else {
                if (firstOccurrence.containsKey(prefixSum - 1)) {
                    maxLen = Math.max(maxLen, i - firstOccurrence.get(prefixSum - 1));
                }
            }
            firstOccurrence.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }
}

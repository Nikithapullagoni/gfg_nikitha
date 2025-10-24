import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int k) {
        // Map to count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        // Map to store how many subsequences end with a certain number
        Map<Integer, Integer> end = new HashMap<>();

        // Count frequency of each number
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freq.get(num) == 0) continue; // already used

            freq.put(num, freq.get(num) - 1);

            // Case 1: If there is a subsequence ending with num-1, extend it
            if (end.getOrDefault(num - 1, 0) > 0) {
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            }
            // Case 2: Try to start a new subsequence of at least length k
            else {
                boolean possible = true;
                for (int i = 1; i < k; i++) {
                    if (freq.getOrDefault(num + i, 0) <= 0) {
                        possible = false;
                        break;
                    }
                }

                if (!possible) return false;

                // Use up next k-1 numbers
                for (int i = 1; i < k; i++) {
                    freq.put(num + i, freq.get(num + i) - 1);
                }

                // Mark that a subsequence now ends with num + k - 1
                end.put(num + k - 1, end.getOrDefault(num + k - 1, 0) + 1);
            }
        }

        return true;
    }
}

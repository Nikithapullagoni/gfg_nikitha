import java.util.*;

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> nums = new ArrayList<>(freq.keySet());

        Collections.sort(nums, (a, b) -> {
            if (freq.get(b).equals(freq.get(a))) {
                return b - a;
            } else {
                return freq.get(b) - freq.get(a);
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(nums.get(i));
        }

        return result;
    }
}

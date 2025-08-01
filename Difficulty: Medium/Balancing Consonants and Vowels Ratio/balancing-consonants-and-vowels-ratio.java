import java.util.*;

class Solution {
    public int countBalanced(String[] arr) {
        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
        int n = arr.length;
        int[] net = new int[n];

        for (int i = 0; i < n; i++) {
            int v = 0, c = 0;
            for (char ch : arr[i].toCharArray()) {
                if (vowelsSet.contains(ch)) v++;
                else c++;
            }
            net[i] = v - c;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int prefix = 0, count = 0;

        for (int i = 0; i < n; i++) {
            prefix += net[i];
            count += freq.getOrDefault(prefix, 0);
            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}
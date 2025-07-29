import java.util.*;

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        HashMap<Character, Integer> firstPos = new HashMap<>();
        HashMap<Character, Integer> lastPos = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        int n = s.length();

        // Record first and last positions
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!firstPos.containsKey(c)) {
                firstPos.put(c, i);
            }
            lastPos.put(c, i);
        }

        // For each character with different first and last positions
        for (char c : firstPos.keySet()) {
            int start = firstPos.get(c);
            int end = lastPos.get(c);
            if (end > start + 1) {
                int sum = 0;
                for (int i = start + 1; i < end; i++) {
                    sum += s.charAt(i);
                }
                if (sum > 0) {
                    result.add(sum);
                }
            }
        }

        return result;
    }
}

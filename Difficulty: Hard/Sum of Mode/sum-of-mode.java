import java.util.*;

class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> freqMap = new TreeMap<>();

        int sum = 0;

        java.util.function.Consumer<Integer> addElem = (x) -> {
            int oldFreq = freq.getOrDefault(x, 0);
            if (oldFreq > 0) {
                TreeSet<Integer> set = freqMap.get(oldFreq);
                set.remove(x);
                if (set.isEmpty()) freqMap.remove(oldFreq);
            }
            int newFreq = oldFreq + 1;
            freq.put(x, newFreq);
            freqMap.computeIfAbsent(newFreq, key -> new TreeSet<>()).add(x);
        };

        java.util.function.Consumer<Integer> removeElem = (x) -> {
            int oldFreq = freq.get(x);
            TreeSet<Integer> set = freqMap.get(oldFreq);
            set.remove(x);
            if (set.isEmpty()) freqMap.remove(oldFreq);

            if (oldFreq == 1) {
                freq.remove(x);
            } else {
                int newFreq = oldFreq - 1;
                freq.put(x, newFreq);
                freqMap.computeIfAbsent(newFreq, key -> new TreeSet<>()).add(x);
            }
        };

        for (int i = 0; i < k; i++) {
            addElem.accept(arr[i]);
        }

        int maxFreq = freqMap.lastKey();
        int mode = freqMap.get(maxFreq).first();
        sum += mode;

        for (int i = k; i < n; i++) {
            removeElem.accept(arr[i - k]);
            addElem.accept(arr[i]);
            maxFreq = freqMap.lastKey();
            mode = freqMap.get(maxFreq).first();
            sum += mode;
        }

        return sum;
    }
}

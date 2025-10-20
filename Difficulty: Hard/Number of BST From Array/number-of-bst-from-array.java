import java.util.*;

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        
        int[] catalan = new int[7];
        catalan[0] = 1;
        for (int i = 1; i <= 6; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        
        for (int x : arr) {
            int index = Arrays.binarySearch(sorted, x);
            int left = index;
            int right = n - index - 1;
            int count = catalan[left] * catalan[right];
            res.add(count);
        }
        
        return res;
    }
}

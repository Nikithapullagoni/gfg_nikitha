import java.util.*;

class Solution {
    public int vowelCount(String s) {
        int[] count = new int[26];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                count[ch - 'a']++;
            }
        }
        
        List<Integer> choices = new ArrayList<>();
        for (char v : vowels) {
            if (count[v - 'a'] > 0) {
                choices.add(count[v - 'a']);
            }
        }
        
        int distinctVowels = choices.size();
        if (distinctVowels == 0) return 0;
        
        int total = 1;
        for (int c : choices) {
            total *= c;
        }
        
        total *= factorial(distinctVowels);
        return total;
    }
    
    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
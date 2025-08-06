class Solution {
    public int romanToDecimal(String s) {
        // Map each Roman numeral to its integer value
        int[] values = new int[26]; // ASCII 'A' to 'Z'
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int curr = values[s.charAt(i) - 'A'];
            
            // If this is not the last character and next symbol is larger, subtract
            if (i + 1 < n && curr < values[s.charAt(i + 1) - 'A']) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }
}

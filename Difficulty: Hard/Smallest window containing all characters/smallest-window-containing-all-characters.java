class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        int[] freqP = new int[26];
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        int[] freqS = new int[26];
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqS[c - 'a']++;

            if (freqS[c - 'a'] <= freqP[c - 'a']) {
                count++;
            }

            while (count == p.length()) {
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                freqS[leftChar - 'a']--;
                if (freqS[leftChar - 'a'] < freqP[leftChar - 'a']) {
                    count--;
                }
                left++;
            }
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}

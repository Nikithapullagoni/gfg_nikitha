import java.util.*;

class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] timesInSeconds = new int[n];

        for (int i = 0; i < n; i++) {
            timesInSeconds[i] = timeToSeconds(arr[i]);
        }

        Arrays.sort(timesInSeconds);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, timesInSeconds[i] - timesInSeconds[i - 1]);
        }

        int wrapAroundDiff = 86400 - timesInSeconds[n - 1] + timesInSeconds[0];
        minDiff = Math.min(minDiff, wrapAroundDiff);

        return minDiff;
    }

    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }
}
class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }
        int count = 0;
        int maxPowerful = -1;
        int lastStart = -1;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            int delta = entry.getValue();

            if (count >= k && lastStart != -1) {
                maxPowerful = Math.max(maxPowerful, point - 1);
            }

            count += delta;

            if (count >= k) {
                lastStart = point;
            } else {
                lastStart = -1;
            }
        }

        return maxPowerful;
    }
}

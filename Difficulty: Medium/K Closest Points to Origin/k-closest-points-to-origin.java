import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];
            return distB - distA;
        });
        
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(point[0]);
            temp.add(point[1]);
            ans.add(temp);
        }
        
        return ans;
    }
}

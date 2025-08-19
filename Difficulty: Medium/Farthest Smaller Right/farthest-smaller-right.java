import java.util.*;

class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        int[] suffMin = new int[n];
        int[] suffIdx = new int[n];
        
        suffMin[n-1] = arr[n-1];
        suffIdx[n-1] = n-1;
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] < suffMin[i+1]) {
                suffMin[i] = arr[i];
                suffIdx[i] = i;
            } else {
                suffMin[i] = suffMin[i+1];
                suffIdx[i] = suffIdx[i+1];
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int l = i+1, r = n-1, res = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (suffMin[mid] < arr[i]) {
                    res = suffIdx[mid];
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ans.add(res);
        }
        
        return ans;
    }
}

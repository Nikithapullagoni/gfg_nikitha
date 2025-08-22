class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 1, high = 2000; // range given in constraints
        int desired = (n * m + 1) / 2;
        
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            
            for (int i = 0; i < n; i++) {
                count += countLessEqual(mat[i], mid);
            }
            
            if (count < desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    // helper to count elements <= target in a sorted row
    private int countLessEqual(int[] row, int target) {
        int l = 0, r = row.length; // binary search like upper_bound
        while (l < r) {
            int mid = (l + r) / 2;
            if (row[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; // number of elements <= target
    }
}
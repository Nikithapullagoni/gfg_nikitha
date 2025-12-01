class Solution {
    public int getSingle(int[] arr) {
        int res=0;
        for(int n:arr){
            res^=n;
        }
        return res;
    }
}
class Solution {
    public int getSecondLargest(int[] arr) {
        int n=arr.length;
        if(n<2)
          return -1;
        Arrays.sort(arr);
        
        int largest=arr[n-1];
        
        for(int i=n-2;i>=0;i--)
        {
             if(arr[i]<largest)
                return arr[i];
        }
        return -1;
    }
}
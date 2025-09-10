class Solution {
    public String largestSwap(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int[] rightMaxIdx = new int[n];
        rightMaxIdx[n-1] = n-1;

        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > arr[rightMaxIdx[i+1]]) {
                rightMaxIdx[i] = i;
            } else {
                rightMaxIdx[i] = rightMaxIdx[i+1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < arr[rightMaxIdx[i]]) {
                char temp = arr[i];
                arr[i] = arr[rightMaxIdx[i]];
                arr[rightMaxIdx[i]] = temp;
                break;
            }
        }

        return new String(arr);
    }
}

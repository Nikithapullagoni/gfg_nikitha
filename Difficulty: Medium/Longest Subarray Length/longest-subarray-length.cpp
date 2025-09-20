class Solution {
public:
    int longestSubarray(vector<int>& arr) {
        int n = arr.size();
        stack<int> ss;
        vector<int> next(n, n), prev(n, -1);
        for(int i = 0; i < n; i++){
            while(ss.size() && arr[ss.top()] < arr[i]){
                next[ss.top()] = i;
                ss.pop();
            }
            ss.push(i);
        }
        while(ss.empty())ss.pop();
        for(int i = n - 1; i >= 0; i--){
            while(ss.size() && arr[ss.top()] < arr[i]){
                prev[ss.top()] = i;
                ss.pop();
            }
            ss.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            int len = next[i] - prev[i] - 1;
            if(arr[i] <= len) ans = max(ans, len);
        }
        return ans;
    }
};

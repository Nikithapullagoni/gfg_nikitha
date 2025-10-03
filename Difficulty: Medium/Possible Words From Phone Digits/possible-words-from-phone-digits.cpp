class Solution {
  public:
    vector<string> possibleWords(vector<int> &arr) {
        vector<string> result;
        if (arr.empty()) return result;
        
        vector<string> keypad = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        string current;
        backtrack(arr, 0, current, result, keypad);
        return result;
    }
    
  private:
    void backtrack(vector<int>& arr, int index, string& current, 
                   vector<string>& result, vector<string>& keypad) {
        if (index == arr.size()) {
            result.push_back(current);
            return;
        }
        
        string letters = keypad[arr[index]];
        if (letters.empty()) {
            backtrack(arr, index + 1, current, result, keypad); // skip 0 and 1
            return;
        }
        
        for (char c : letters) {
            current.push_back(c);
            backtrack(arr, index + 1, current, result, keypad);
            current.pop_back();
        }
    }
};

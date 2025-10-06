class Solution {
  public:
    int dx[8] = {2, 1, -1, -2, -2, -1, 1, 2};
    int dy[8] = {1, 2, 2, 1, -1, -2, -2, -1};
    
    bool isSafe(int x, int y, int n, vector<vector<int>> &board) {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }
    
    bool solve(int x, int y, int movei, int n, vector<vector<int>> &board) {
        if (movei == n * n) return true;
        
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if (isSafe(nx, ny, n, board)) {
                board[nx][ny] = movei;
                if (solve(nx, ny, movei + 1, n, board))
                    return true;
                else
                    board[nx][ny] = -1; // backtrack
            }
        }
        return false;
    }
    
    vector<vector<int>> knightTour(int n) {
        vector<vector<int>> board(n, vector<int>(n, -1));
        board[0][0] = 0; // start from (0, 0)
        
        if (!solve(0, 0, 1, n, board))
            return {{-1}};
        
        return board;
    }
};

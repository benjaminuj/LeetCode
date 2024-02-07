class Solution {
    public void solveSudoku(char[][] board) {
        back(board, 0);
    }
    
    public boolean back(char[][] board, int n) {
        if (n == 81) return true;
        
        int r = n/9 ,c = n%9;
        
        if (board[r][c] != '.') return back(board,n+1);
        else {
            for (int i= 0 ; i <9 ;i ++) {
                char value = (char)(i + (int)'1');
                if (!isValid(board, r, c, value)) continue;
                 
                board[r][c] = value;
                if (back(board,n+1)) return true;
                board[r][c] = '.';
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int r, int c, char value) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == value || board[i][c]== value) return false;
           
        }
        
        int sr = (r / 3) * 3,
            sc = (c / 3) * 3;
        for (int dr = 0; dr < 3; dr++) {
            for (int dc = 0; dc < 3; dc++) {
                if (board[sr+dr][sc+dc] == value) return false;
            }
        }
        
        return true;
    }
}
class Solution {
    int[][] dr = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}}; // 대각선 체크
    List<List<String>> answer;
    public List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();
        String[][] board = new String[n][n];
        for (int i =0 ; i< n; i++) {
            Arrays.fill(board[i], ".");
        }
        
        for (int i =0 ; i < n ;i++) {
            board[0][i] = "Q";
            back(0, i, n, 1, board);
            board[0][i] = ".";
        }
        return answer;
    }
    
    public void back(int r, int c, int n, int cnt, String[][] board) {
        if (cnt == n) {
            List<String> t = new ArrayList<>();
            for (int i =0 ; i< n; i++) {
                String temp = String.join("", board[i]);
                t.add(temp);
            }
            answer.add(t);

            return;
        }
        
        int nR = r + 1;
        if (nR == n) return;
        
        outer:
        for (int can =0; can < n; can++) {
            int nC = can;
        
            // 같은 행 열 체크
            for (int i =0 ; i < n ;i++) {
                if (board[nR][i].equals("Q") || board[i][nC].equals("Q")) continue outer;
            }

            
            // 대각선 체크
            for (int[] d : dr) {
                int rToCheck = nR;
                int cToCheck = nC;
                
                while (true) {
                    rToCheck += d[0];
                    cToCheck += d[1];
                    if (!isValid(rToCheck, cToCheck, n)) break;
                    
                    if (board[rToCheck][cToCheck].equals("Q")) continue outer; 
                }
            }

            board[nR][nC] = "Q";
            back(nR, nC, n, cnt+1, board);
            board[nR][nC] = ".";
        }

    }
    
    public boolean isValid(int r, int c, int n) {
        return r >=0 && r < n && c >= 0 && c < n;
    }
}
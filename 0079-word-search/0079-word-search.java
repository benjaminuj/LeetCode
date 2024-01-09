class Solution {
    boolean answer = false;
    //북동남서
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == word.charAt(0)) {
                    backtracking(new boolean[board.length][board[x].length], x, y, 1, word, board);
                }    
            }
        }    
        
        return answer;
    }
    
    public void backtracking(boolean[][] visited, int x, int y, int strLen, String word, char[][] board) {
        //basecase
        if (strLen == word.length()) {
            answer = true;
            return;
        }    
        
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if ((nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length) && !visited[nextX][nextY]) {
                if (board[nextX][nextY] == word.charAt(strLen)) {
                    backtracking(visited, nextX, nextY, strLen+1, word, board);
                }
            }
        }
        
        visited[x][y] = false;
    }
}
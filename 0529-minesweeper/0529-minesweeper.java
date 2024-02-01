import java.util.*;

class Solution {
    int[][] dr = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    int m, n;
    boolean beBomb = false;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Deque<Info> q = new ArrayDeque<>();
        q.offer(new Info(click[0], click[1]));
        visited[click[0]][click[1]] = true;
        
        while(!q.isEmpty()) {
            Info cur = q.poll();
            int bombCnt = 0;
            int totalCheckCnt = 0; 
            
            if (board[cur.r][cur.c] == 'M') {
                board[cur.r][cur.c] = 'X';
                    break;
            }
            
            for (int[] d : dr) {
                int nR = cur.r + d[0];
                int nC = cur.c + d[1];
                
                if (isRange(nR, nC) && !visited[nR][nC]) {
                    totalCheckCnt++;
                    if (board[nR][nC] == 'M') {
                        bombCnt++;
                        continue;
                    }
                
                    q.offer(new Info(nR, nC));
                    visited[nR][nC] = true;

                }
            }

            if (bombCnt > 0) {
                board[cur.r][cur.c] = (char)(bombCnt + '0');
                for (int i = 0; i < totalCheckCnt - bombCnt; i++) {
                    Info l = q.removeLast();
                    visited[l.r][l.c] = false;
                }
            } else {
                board[cur.r][cur.c] = 'B';
            }
        }
        return board;
    }
    
    public boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }
    
    class Info {
        int r, c;
        
        public Info (int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
}
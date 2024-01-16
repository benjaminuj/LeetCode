class Solution {
    int dr[][] = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    boolean[][] visited;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        
        if (grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) {
            return -1;
        }
        
        return bfs(0,0, grid);
    }
    
    public boolean isValid(int r, int c, int rLen, int cLen, int[][] grid) {
        return ((r >= 0 && r < rLen && c >= 0 && c < cLen) && !visited[r][c] && grid[r][c] == 0);
    }
    
    public int bfs(int r, int c, int[][] grid) {
        Queue<Info> q = new ArrayDeque<>();
        q.offer(new Info(r, c, 1));
        visited[r][c] = true;
        
        while (!q.isEmpty()) {
            Info now = q.poll();
            
            if (now.r == grid.length-1 && now.c == grid[0].length-1) {
                return now.cnt;
            }
            for (int[] d : dr) {
                int nextR = now.r + d[0];
                int nextC = now.c + d[1];
            
                if (isValid(nextR, nextC, grid.length, grid[0].length, grid)) {
                    q.offer(new Info(nextR, nextC, now.cnt + 1));
                    visited[nextR][nextC] = true;
                }
            }
        }
        return -1;
    }
}

class Info {
    int r;
    int c;
    int cnt;
    public Info(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}
class Solution {
    int n;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[0][0] == 1) return -1;
        if (grid[0][0] == 0 && n ==1) return 1;
        
        
        int[][] dr = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q= new ArrayDeque<>();
        
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur= q.poll();
            int cnt = cur[2];
            
            for (int[] d : dr) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                
                if (isValid(nr, nc) && !visited[nr][nc] && grid[nr][nc] == 0) {
                    if (nr == n-1 && nc == n-1) return cnt+1;
                    
                    q.add(new int[]{nr, nc, cnt+1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
    
    public boolean isValid(int r, int c) {
        return r >=0 && c >= 0 && r < n && c < n;
    }
}
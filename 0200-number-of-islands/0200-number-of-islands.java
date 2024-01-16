class Solution {
    int[][] dr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
    boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        int answer = 0;
        visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public boolean isValid(int r, int c, int rLen, int cLen, char[][] grid) {
        return ((r >= 0 && r < rLen && c >= 0 && c < cLen) && !visited[r][c] && grid[r][c] == '1'); 
    }
    
    public void bfs(int r, int c, char[][] grid) {
        Queue<Info> q = new ArrayDeque<>();
        q.offer(new Info(r, c));
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            Info now = q.poll();
            
            for (int[] d : dr) {
                int nextR = now.r + d[0];
                int nextC = now.c + d[1];
                
                if (isValid(nextR, nextC, visited.length, visited[0].length, grid)) {
                    q.offer(new Info(nextR, nextC));
                    visited[nextR][nextC] = true;
                }
            }
        }
    }
}

class Info {
    int r;
    int c;
    public Info(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
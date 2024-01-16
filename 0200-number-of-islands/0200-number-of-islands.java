class Solution {
    int[] dr = new int[]{0, 1, 0, -1};
    int[] dc = new int[]{1, 0, -1, 0};
    boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        int answer = 0;
        visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public boolean isValid(int r, int c, int rLen, int cLen, char[][] grid) {
        if ((r >= 0 && r < rLen && c >= 0 && c < cLen) && !visited[r][c] && grid[r][c] == '1') {
            return true;
        }
        return false;
    }
    
    public void dfs(int r, int c, char[][] grid) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            
            if (isValid(nextR, nextC, visited.length, visited[0].length, grid)) {
                dfs(nextR, nextC, grid);
            }
        }
    }
}
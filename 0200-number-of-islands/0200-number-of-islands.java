class Solution {
    int[][] dr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 개선
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
        return ((r >= 0 && r < rLen && c >= 0 && c < cLen) && !visited[r][c] && grid[r][c] == '1'); // 개선
    }
    
    public void dfs(int r, int c, char[][] grid) {
        visited[r][c] = true;
        for (int[] d : dr) { // 개선
            int nextR = r + d[0];
            int nextC = c + d[1];
            
            if (isValid(nextR, nextC, visited.length, visited[0].length, grid)) {
                dfs(nextR, nextC, grid);
            }
        }
    }
}
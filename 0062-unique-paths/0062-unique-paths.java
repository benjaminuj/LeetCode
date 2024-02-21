class Solution {
    int[][] dis;
    
    public int uniquePaths(int m, int n) {
        dis = new int[m][n];
        dis[0][0] = 1;
        
        back(m-1,n-1);
        
        return dis[m-1][n-1];
        
    }
    
    public int back(int r, int c) {
        if (c < 0 || r < 0) {
            return 0;
        }
        if (dis[r][c] != 0) return dis[r][c];
        dis[r][c] = back(r,c-1) + back(r-1,c);
        return dis[r][c];
    }
}
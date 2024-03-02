class Solution {
    public int maximalSquare(char[][] matrix) {
        int answer= 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for( int i =0; i < matrix[0].length; i++) {
            dp[0][i] = (int)matrix[0][i] - '0';
            if (matrix[0][i] == '1') answer=1;
        }
        
        for (int i =0; i < matrix.length; i++) {
            dp[i][0] = (int)matrix[i][0] - '0';
            if (matrix[i][0] == '1') answer=1;
        }
        
        for (int r= 1 ; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if(matrix[r][c] != '1') {
                    System.out.print(dp[r][c]); 
                    continue;
                }
                
                if (answer == 0 && matrix[r][c] == '1') answer=1;
                if (matrix[r-1][c] == '1' && matrix[r][c-1] == '1') {
                    if (matrix[r-1][c-1] == '1') {
                        if (dp[r][c-1] == 0 || dp[r-1][c] == 0) {
                            dp[r][c] = 2;
                        } else {
                            int temp = Math.min(dp[r][c-1], dp[r-1][c]);
                            if (matrix[r-temp][c-temp] =='1') {
                                dp[r][c] = temp + 1; 
                            } else {
                                dp[r][c] = temp; 
                            }
                        
                        }
                        
                        answer = answer < dp[r][c] ? dp[r][c] : answer;
                    }
                }
                System.out.print(dp[r][c]);
                 
            }
            System.out.println();
        }
        return answer*answer;
    }
}
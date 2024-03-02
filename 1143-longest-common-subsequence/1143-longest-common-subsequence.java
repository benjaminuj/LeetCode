class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() +1][text2.length()+1];
        
        for (int r= 1; r <= text1.length(); r++) {
            char c1 = text1.charAt(r-1);
            for (int c=1; c<= text2.length(); c++) {
                char c2 = text2.charAt(c-1);
                
                if (c1 == c2) {
                    dp[r][c] = dp[r-1][c-1] +1;
                } else {
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
class Solution {
    int[] dp;
    
    public int climbStairs(int n) {
        dp = new int[n+1];
        back(n);
        return dp[n];
    }

    public int back(int n) {
        if (n == 1 || n == 2) {
            dp[n] = n;
            return dp[n];
        }
        
        if (dp[n] != 0) return dp[n];

        dp[n] = back(n-1) + back(n-2);
        return dp[n];
    }
}
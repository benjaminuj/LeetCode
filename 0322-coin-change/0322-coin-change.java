class Solution {
    final int LIMIT = 10001;
    
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        
        Arrays.fill(memo, LIMIT);
        return dp(memo, coins, amount);
    }
    
    public int dp(int[] memo, int[] coins, int amount) {
        if(amount == 0) return 0;
        
        int result = LIMIT;
        
        for (int coin : coins) {
            if (amount - coin >= 0) {
                if (memo[amount-coin] == LIMIT) {
                    memo[amount-coin] = dp(memo, coins, amount-coin);
                }
                
                if (memo[amount-coin] != -1) {
                    result = Math.min(result, memo[amount-coin]);
                }
            } 
        }
        return result == LIMIT ? -1 : result + 1;
    }
}
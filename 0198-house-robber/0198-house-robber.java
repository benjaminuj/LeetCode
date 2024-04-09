class Solution {
    final int LIMIT = Integer.MIN_VALUE;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, LIMIT);
        
        return Math.max(dp(nums, nums.length-1, memo), dp(nums, nums.length-2, memo));
    }
    
    public int dp(int[] nums, int n, int[] memo) {
        if (n == 0) return nums[0];
        if (n == 1) return nums[1];
        
        int result = LIMIT;
        
        for (int i = 2; i <= 3; i++) {
            if (n - i >= 0) {
                if (memo[n-i] == LIMIT) {
                    memo[n-i] = dp(nums, n-i, memo);
        
                }
                
                result = Math.max(result, memo[n-i]);
            }
        }
        
        return result == LIMIT ? memo[n] : result + nums[n];
    }
}
class Solution {
    private int[] cnt = {2,3};
    
    public int rob(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, Integer.MIN_VALUE);
        if(nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        
        int n1 = dp(nums, result, nums.length-1);
        int n2 = dp(nums, result, nums.length-2);
        
        return n1 < n2 ? n2 : n1;
    }
    
    int dp(int[] nums, int[] result, int i) {
        int value = Integer.MIN_VALUE;
        if (i == 0) return nums[0];
        if (i == 1) return nums[1];
        
        for (int n : cnt) {
            if (i - n < 0) break;
            
           if (result[i-n] == Integer.MIN_VALUE) {
                value = dp(nums, result, i-n) + nums[i];
           } else {
               value = result[i-n] + nums[i];
           }
            
            
            
            result[i] = Math.max(result[i], value);
            
        }
        return result[i];
    }
}
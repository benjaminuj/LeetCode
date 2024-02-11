class Solution {
    public int removeDuplicates(int[] nums) {
        int base = nums[0];
        int cnt = 1, idx = 1;
        int[] answer = new int[nums.length];
        answer[0] = base;
        int result = 1;
        
        for (int i =1; i < nums.length; i++) {
            answer[idx++] = nums[i];
            result++;
            
            if (base == nums[i]) {
                cnt++;
                
                if (cnt >= 3) {
                    idx--;
                    result--;
                }
            } else {
                cnt=1;
                base = nums[i];
            }
            
        }
        System.arraycopy(answer, 0, nums, 0, result);
        
        return result;
    }
}
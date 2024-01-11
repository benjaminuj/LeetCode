class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int[] copy = Arrays.copyOf(nums, nums.length);
        boolean leftDone = false;
        boolean rightDone = false;
        
        Arrays.sort(nums);
        
        int l = 0; 
        int r = nums.length - 1;
        
        while (l <= r) {
            if (nums[l] + nums[r] < target) {
                l++;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] == target) {
                break;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!leftDone && copy[i] == nums[l]) {
                answer[0] = i;
                leftDone = true;
            } else if (!rightDone && copy[i] == nums[r]) {
                answer[1] = i;
                rightDone = true;
            }
            
            if (leftDone && rightDone) {
                break;
            }
        }
        return answer;
    }
}
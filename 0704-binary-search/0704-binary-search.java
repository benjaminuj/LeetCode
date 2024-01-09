class Solution {
    int answer;
    public int search(int[] nums, int target) {
        binarysearch(nums, target, 0, nums.length - 1);
        
        return answer;
    }
                 
    public void binarysearch(int[] nums, int target, int l, int r) {
        if (l > r) {
            answer = -1;
            return;
        }
        
        int mid = (l + r) / 2;
        
        if (nums[mid] == target) {
            answer = mid;
            return;
        }
        if (nums[mid] < target) {
            binarysearch(nums, target, mid+1, r);
        }
        if (nums[mid] > target) {
            binarysearch(nums, target, l, mid-1);
        }
    }
}
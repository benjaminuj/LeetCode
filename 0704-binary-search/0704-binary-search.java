class Solution {
    int answer;
    public int search(int[] nums, int target) {
        int found = Arrays.binarySearch(nums, target);
        
        if (found < 0) {
            return -1;
        } else {
            return found;
        }
    }
                 
    
}
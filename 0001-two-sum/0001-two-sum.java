class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        int l = 0, r = nums.length - 1;
        
        while(l < r) {
            if (arr[l][0] + arr[r][0] > target) {
                r--;
            } else if(arr[l][0] + arr[r][0] < target) {
                l++;
            } else {
                return new int[]{arr[l][1], arr[r][1]};
            }
        }
        
        return new int[]{-1, -1};
    }
}
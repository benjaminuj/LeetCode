class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
		
		// split into first and second half (in fact we do not even need the sort, just easier to calculate upper bound this way)
        int[] firstHalf = new int[n];
        for (int i = 0; i < n; i++) {
            firstHalf[i] = nums[i];
        }
        int[] secondHalf = new int[n];
        for (int i = 0; i < n; i++) {
            secondHalf[i] = nums[n + i];
        }
        
        int firstSum = 0;
        for (int num : firstHalf) firstSum += num;
        
        int minimal = Math.abs(sum - 2 * firstSum);
        for (int i = 1; i < n; i++) {
            int other = n - i; // pick i from first half and pick other from second half
            List<Integer> firstList = new ArrayList<>();
            helper(firstHalf, 0, 0, 0, i, firstList);
            TreeSet<Integer> set = new TreeSet<>(firstList); // prepare for binary search
            
            List<Integer> secondList = new ArrayList<>();
            helper(secondHalf, 0, 0, 0, other, secondList);
            for (int second : secondList) {
                int target = sum / 2 - second;
                Integer floor = set.floor(target); // search for a smaller value
                if (floor != null) {
                    int curSum = second + floor;
                    int curAbs = Math.abs(sum - curSum * 2);
                    if (curAbs < minimal) {
                        minimal = curAbs;
                    }
                }
                Integer ceiling = set.ceiling(target); // search for a larget value
                if (ceiling != null) {
                    int curSum = second + ceiling;
                    int curAbs = Math.abs(sum - curSum * 2);
                    if (curAbs < minimal) {
                        minimal = curAbs;
                    }
                }
            }
        }
        
        return minimal;
    }
    
    private void helper(int[] nums, int ptr, int pickedCount, int sum, int targetCount, List<Integer> vals) { // calculate all possible sums when picking targetCount from array
        if (pickedCount > targetCount) return;
        
        if (pickedCount == targetCount) {
            vals.add(sum);
            return;
        }
        
        if (ptr == nums.length) return;
        
        helper(nums, ptr + 1, pickedCount, sum, targetCount, vals);
        helper(nums, ptr + 1, pickedCount + 1, sum + nums[ptr], targetCount, vals);
    }
}
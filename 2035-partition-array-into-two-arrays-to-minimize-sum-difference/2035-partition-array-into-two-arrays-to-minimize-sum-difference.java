class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length/2;
        int sum = Arrays.stream(nums).sum();
        double target = sum/2.0; // 더 정확하게 계산하기 위해 정수가 아닌 실수타입으로 하는건가요? 
        List<List<Integer>> partialSums1 = getPartialSums(nums, 0, n);
        List<List<Integer>> partialSums2 = getPartialSums(nums, n, n*2);
        
        double best = Double.MAX_VALUE;
        for (int k = 0; k  <partialSums1.size(); k++) {
            List<Integer> sums1 = partialSums1.get(k);
            List<Integer> sums2 = partialSums2.get(partialSums2.size()-1-k);
            for (int sum1 : sums1) {
                double targetDiff = target - sum1;
                int index = Collections.binarySearch(sums2, (int)targetDiff);
                
                if (index < 0) index = ((index +1) * -1); 
                
                if (index < sums2.size()) {
                    best = Math.min(best, sum1 + sums2.get(index) - target);
                }
            }
        }
        return Math.abs((int)(best*2.0));
    }
    
    List<List<Integer>> getPartialSums(int[] nums, int start, int end) {
        int len = end - start;
        List<List<Integer>> result = new ArrayList<>();
        for (int i =0 ; i<= len; i++) {
            result.add(new ArrayList<>());
        }
        for (int mask =0; mask < (1 << len); mask++) {
            int sum =0;
            for (int i = 0; i < len; i++) {
                if ((mask>>i & 1) == 1) {
                    sum += nums[start+i];
                }
            }
            int pickCount = Integer.bitCount(mask);
            result.get(pickCount).add(sum);
        }
        for (List<Integer> sums : result) {
            Collections.sort(sums);
        }
        return result;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> m = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int answer = 0;
        
        for (int i =0; i < nums.length; i++) {
            int s = nums[i];
            int len = 0;
            
            if (!m.contains(s-1)) {
                len = 1;
                
                while(true) {
                    if (m.contains(s+1)) {
                        len++;
                        s++;
                    } else {
                        break;
                    }
                }
            }

            if (answer < len) answer = len;
            if (len > nums.length/2 + 1) break;
        }
        return answer;
        
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        boolean duplicated = false;
        Map<Integer, Edge> numsMap = new HashMap<>(); // 값, Edge(개수, 인덱스)
        for (int i =0 ; i < nums.length; i++) {
            numsMap.putIfAbsent(nums[i], new Edge(0, -1));
            
            numsMap.put(nums[i], new Edge(numsMap.get(nums[i]).cnt +1, i));
        }
        
        int[] answer = new int[2];
        int diff = 0;
        
        for (int i =0; i < nums.length; i++) {
            diff = target - nums[i];
            numsMap.put(nums[i], new Edge(numsMap.get(nums[i]).cnt - 1, i));
            
            if (numsMap.containsKey(diff)) {
                if (nums[i] == diff && numsMap.get(diff).cnt > 0) {
                    duplicated = true;
                    break;
                } else if (nums[i] == diff && numsMap.get(diff).cnt == 0) {
                    continue;
                }
                // int cnt = getValueCnt(diff, nums); 
                // System.out.println(diff);
                // if (cnt != 1) {
                //     System.out.println(cnt);
                //     duplicated = true;
                //     break;
                // }
                System.out.println(i);
                answer[0] = i;
                answer[1] = numsMap.get(diff).index;
                Arrays.sort(answer);
                break;
            }
            numsMap.put(nums[i], new Edge(numsMap.get(nums[i]).cnt + 1, i));
        }
        
        if (duplicated) {
            int idx = 0;
            for (int i =0; i < nums.length; i++) {
                if (nums[i] == diff) {
                    answer[idx++] = i;
                }
                if (idx == 2) break;
            }
        }
        
        return answer;
    }
    
    class Edge {
        int cnt;
        int index;
        
        public Edge(int cnt, int index) {
            this.cnt = cnt;
            this.index = index;
        }
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> q = new PriorityQueue<int[]>((o1,o2) -> (o1[0] - o2[0])); // 값, 위치 인덱스, list인덱스
        int[] answer = new int[2];
        int[] max = {-1, 0,0};
        
        for (int i =0 ; i < nums.size(); i++) {
            q.offer(new int[]{nums.get(i).get(0), 0, i});
            
            if (max[0] < nums.get(i).get(0)) {
                max = new int[]{nums.get(i).get(0), 0,i};
            }  
        }
        
        int[] range = {1000000, max[0]};
        
        while(true) {
            int[] cur = q.poll();
            if (Math.abs(range[0] - range[1]) > Math.abs(cur[0] - max[0])) {
                range = new int[]{cur[0], max[0]};
            }
            
            if (cur[1] +1 == nums.get(cur[2]).size()) {
                break;
            }
            
            if (max[0] < nums.get(cur[2]).get(cur[1]+1)) {
                max = new int[]{nums.get(cur[2]).get(cur[1]+1), cur[1]+1, cur[2]};
            }
            
            q.offer(new int[]{nums.get(cur[2]).get(cur[1]+1), cur[1]+1, cur[2]});
            
        }
        
        
        return range; 
    }
            
}
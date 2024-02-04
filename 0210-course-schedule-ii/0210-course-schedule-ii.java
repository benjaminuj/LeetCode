class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] answer = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0, idx = 0;
        
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[1], new ArrayList<>()); 
            List<Integer> temp = graph.get(pre[1]);
            temp.add(pre[0]);
            indegree[pre[0]]++;
        }
        
        for (int i =0 ; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                cnt++;
            }
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            answer[idx++] = cur;
            
            if (!graph.containsKey(cur)) continue;
            for (int n : graph.get(cur)) {
                indegree[n]--;
                
                if (indegree[n] == 0) {
                    q.offer(n);
                    cnt++;
                }
            }
        }
        
        if (cnt != numCourses) {
            return new int[]{};
        } 
        
        return answer;
    }
}
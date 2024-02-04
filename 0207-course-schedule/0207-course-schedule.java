class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        //선행코스를 key로 
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();

        int count = 0;
        for (int c = 0; c < numCourses; c++) {
            if (indegree[c] == 0) {
                q.add(c);
                count++;
            }
        }
        
        while(!q.isEmpty()) {
            int cur = q.remove();
            
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        count++;
                        q.add(next);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
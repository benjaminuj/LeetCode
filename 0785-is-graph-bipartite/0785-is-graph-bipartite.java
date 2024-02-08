class Solution {
    int[] visited;
    Map<Integer, List<Integer>> g;
    public boolean isBipartite(int[][] graph) {
        g = new HashMap<>();
        visited = new int[graph.length];
        
        // O(10^4) 인데 줄일까
        for (int i = 0; i < graph.length; i++) {
            g.putIfAbsent(i, new ArrayList<>());
            for (int j =0 ; j<graph[i].length; j++) {
                g.putIfAbsent(graph[i][j], new ArrayList<>());
                g.get(i).add(graph[i][j]);
                g.get(graph[i][j]).add(i);
            } 
        }
        
        for (int i =0 ; i < graph.length; i++) {
            if (visited[i] == 0) {
                if (!bfs(i)) return false;
            }
        }
        
        return true;

    }
    
    boolean bfs(int s) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{s, 1});
        visited[s] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int n : g.get(cur[0])) {
                if (visited[n] == cur[1]) return false;
                if(visited[n] == 0) {
                    q.offer(new int[]{n , 3-cur[1]});
                    visited[n] = 3-cur[1];
                }
            }
        }
        
        return true;
    }
}
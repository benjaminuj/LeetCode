class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = Arrays.stream(times).collect(Collectors.groupingBy(t -> t[0]));
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> (e1[1] - e2[1]));
        pq.add(new int[]{k, 0});
        visited[k] = 0;
        
        int maxTime = 0;
        int visitCount = 1;
        while(!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[0], time = cur[1];
            if (visited[u] < time) continue;
            maxTime = time;
            
            if (!edges.containsKey(u)) continue;
            for (int[] edge : edges.get(u)) {
                int v = edge[1], w = edge[2];
                
                if (time + w >= visited[v]) continue;
                
                if (visited[v] == Integer.MAX_VALUE) visitCount++;
                visited[v] = time + w;
                pq.add(new int[]{v, time + w});
            } 
        }
        return visitCount == n ? maxTime : -1;
    }
}
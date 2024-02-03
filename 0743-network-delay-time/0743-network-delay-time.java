class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int answer = 0;
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        Map<Integer, List<Entry>> graph = new HashMap<>();
        
        for (int i =0 ; i < times.length; i++) {
            List<Entry> temp = graph.get(times[i][0]);
            
            if (temp == null) {
                temp = new ArrayList<>();
                graph.put(times[i][0], temp);
            }
            
            temp.add(new Entry(times[i][1], times[i][2])); // 도착지, 시간
        }
        
        Queue<Entry> q = new PriorityQueue<>();
        q.offer(new Entry(k, 0)); // 현재 노드, 현재 노드까지 누적 걸린시간
        distance[k] = 0;
        while(!q.isEmpty()) {
            Entry cur = q.poll();
            if (distance[cur.node] < cur.time) continue;
            
            if (graph.get(cur.node) == null) { // 아래 NPE 에러 해결 로직
                int max = Arrays.stream(distance).max().getAsInt();
                if (max == Integer.MAX_VALUE) {
                    answer = -1;
                } else {
                    answer= max;
                }
                continue;
            }
            
            for (Entry e : graph.get(cur.node)) { // NPE 에러 주의
                int to = e.node;
                int newDist = cur.time + e.time;
                if (newDist < distance[to]) {
                    distance[to] = newDist;
                    q.offer(new Entry(to, newDist));
                }
            }

        }
        int max = Arrays.stream(distance).max().getAsInt();
        
        if (max == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = max;
        }
        return answer;
        
    }
    
    class Entry implements Comparable<Entry>{
        int node;
        int time;
        
        public Entry(int node, int time) {
            this.node = node;
            this.time = time;
        }
        
        @Override
        public int compareTo(Entry o) {
            return this.time - o.time;
        }
    }
}
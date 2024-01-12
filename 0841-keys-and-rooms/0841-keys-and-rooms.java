class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer>[] list = new ArrayList[rooms.size()];
        boolean[] visited = new boolean[list.length];
        
        for (int i = 0; i < rooms.size(); i++) {
            list[i] = new ArrayList<>();
            
            for (int j = 0; j < rooms.get(i).size(); j++) {
                list[i].add(rooms.get(i).get(j));
            }
        }
        
        bfs(list, visited);
        
        for (int i = 0; i < list.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void bfs(List<Integer>[] list, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(0);
        visited[0] = true;
        
        while (!q.isEmpty()) {
            for (int next : list[q.peek()]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
            q.remove();
        }
    }
}
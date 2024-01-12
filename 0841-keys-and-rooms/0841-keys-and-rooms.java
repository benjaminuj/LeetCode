class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
                
        dfs(0, rooms, visited);
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs(int v, List<List<Integer>> rooms, boolean[] visited) {
        visited[v] = true;
        
        for (Integer next : rooms.get(v)) {
            if (!visited[next]) {
                dfs(next, rooms, visited);
            }
        }
    }
}
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
        
        dfs(0, list, visited);
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs(int start, List<Integer>[] list, boolean[] visited) {
        visited[start] = true;
        
        for (int next : list[start]) {
            if (!visited[next]) {
                dfs(next, list, visited);
            }
        }
    }
}
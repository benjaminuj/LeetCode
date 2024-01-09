class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, new boolean[nums.length], new ArrayList<>(), nums);
        
        return answer;
    }
    
    public void backtracking(int start, boolean[] visited, List<Integer> current, int[] nums) {
        answer.add(new ArrayList<>(current));
        
        if (current.size() == nums.length) {
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                backtracking(i + 1, visited, current, nums);
                visited[i] =false;
                current.remove(current.size() - 1);
            }
        }
    }
}
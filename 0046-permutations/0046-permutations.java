class Solution {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, 0, new ArrayList<Integer>(), new boolean[nums.length]);

        return answer;
    }

    public void backtracking(int[] nums, int number, List<Integer> current, boolean[] visited) {
        //basecase
        if (number == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                backtracking(nums, number+1, current, visited);
                
                visited[i] = false;
                current.remove(current.size() - 1);
            }
            
        }
    }
}
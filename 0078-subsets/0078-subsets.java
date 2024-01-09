class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, new ArrayList<>(), nums);
        
        return answer;
    }
    
    public void backtracking(int start, List<Integer> current, int[] nums) {
        answer.add(new ArrayList<>(current));
        
        if (current.size() == nums.length) {
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtracking(i + 1, current, nums);
            current.remove(current.size() - 1);   
        }
    }
}
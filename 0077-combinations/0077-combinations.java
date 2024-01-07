class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k, new ArrayList<Integer>());

        return answer;
    }

    public void backtracking(int start, int n, int k, List<Integer> current) {
        if (current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtracking(i + 1, n, k, current);
            current.remove(current.size() - 1);
        }
    }
}
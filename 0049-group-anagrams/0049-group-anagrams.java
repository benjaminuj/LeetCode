class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        String[] afterSort = new String[strs.length];
        for (int i =0; i < strs.length; i++) {
            String[] temp = strs[i].split("");
            Arrays.sort(temp);
            afterSort[i] = Arrays.toString(temp);;
        }
        
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i =0; i < afterSort.length; i++) {
            String str = afterSort[i];
            
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(i);
        }
        
        for (String str : map.keySet()) {
            List<String> subAnswer = new ArrayList<>();
            List<Integer> indexes = map.get(str);
            
            for (int j = 0; j < indexes.size(); j++) {
                int idx = indexes.get(j);
                subAnswer.add(strs[idx]);
                
            }
            answer.add(subAnswer);
        }
        return answer;
    }
    
}
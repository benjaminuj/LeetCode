class Solution {
    List<List<String>> answer = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        backtracking(0, s, new boolean[s.length() - 1]);
        
        return answer;
    }
    
    public void backtracking(int start, String s, boolean[] comma) {
        if (comma.length == 0) {
            String[] one = s.split("");
            answer.add(new ArrayList<>(Arrays.asList(one)));
            return;
        }
        
        getAllSubStr(comma, s);
        
        for (int i = start; i < comma.length; i++) {
            if (!comma[i]) {
                comma[i] = true;
                
                backtracking(i + 1, s, comma);
                comma[i] = false;
            }
        }
    }
    
    public void getAllSubStr(boolean[] comma, String s) {
        List<String> current = new ArrayList<>();
        String temp = "";
        
        // 가능한 서브스트링 구하기 
        for (int i = 0; i < comma.length; i++) {
            temp += Character.toString(s.charAt(i));
            
            if (comma[i]) {
                current.add(temp);
                temp = "";
                
                if (i == comma.length - 1) {
                    current.add(Character.toString(s.charAt(s.length()-1)));
                }
            }
            
            if (!temp.isEmpty() && i == comma.length - 1) {
                temp += Character.toString(s.charAt(s.length()-1));
                current.add(temp);
            }
        }
        
        if (current.size() >= 1) {
            checkPalindrome(current);
        }
    }
    
    public void checkPalindrome(List<String> current) {
        for (int i = 0; i < current.size(); i++) {
            String strForCheck = current.get(i);
            int l = 0;
            int r = strForCheck.length()-1;

            while(l <= r) {
                if (strForCheck.charAt(l++) != strForCheck.charAt(r--)) {
                    return;    
                }
            }      
        }
        answer.add(current);
    }
}
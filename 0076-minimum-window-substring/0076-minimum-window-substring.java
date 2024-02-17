class Solution {
    public String minWindow(String s, String t) {
        int minLen = s.length();
        int minStart = 0;
        int minEnd = s.length()-1;
        
        HashMap<Character, Integer> require = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            require.put(c, require.containsKey(c)? require.get(c) +1 : 1);
        }
        
        int cnt = t.length();
        int left = 0;
        for(int i =0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if(require.containsKey(cur)) {
                if (require.get(cur) >0) cnt--;
                require.put(cur, require.get(cur)-1);
            }
            
            // t의 문자들 다 가졌을 때부터 계속 이 실행문 실행 
            // 다 가진 처음에는 끝지점만 알고있으니, 시작점 찾기
            if (cnt == 0) {
                char c = s.charAt(left);
                
                // 시작점의 문자는 필요없는 문자.
                while (!require.containsKey(c) || require.get(c) < 0) {
                    if (require.containsKey(c)) {
                        require.put(c, require.get(c)+1);
                    }
                    left++;
                    c = s.charAt(left);
                }
                
                if (minLen > i - left + 1) {
                    minLen = i - left +1;
                    minStart = left;
                    minEnd = i;
                }

            }
        }
        if (cnt != 0) return "";
        return s.substring(minStart,minEnd+1);
    }
}
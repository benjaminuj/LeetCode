import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> q = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            
            if (now == '(') {
                q.push(')');
            } else if (now == '{') {
                q.push('}');
            } else if (now == '[') {
                q.push(']');
            } else if (!q.isEmpty() && q.peek() == now) {
                q.pop();
            } else {
                return false;
            }
        }
        
        if (q.isEmpty()) {
            return true;
        }
        return false;
    }
}
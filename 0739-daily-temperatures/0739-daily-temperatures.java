class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Info> q = new ArrayDeque<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            if (q.isEmpty()) {
                q.push(new Info(i, temperatures[i]));
                continue;
            }        
                
            while (!q.isEmpty() && q.peek().temp < temperatures[i]) {
                answer[q.peek().day] = i - q.peek().day;
                q.pop();
            }
            
            q.push(new Info(i, temperatures[i]));
        }
        return answer;
    }
}

class Info {
    int day;
    int temp;
    
    public Info (int day, int temp) {
        this.day = day;
        this.temp = temp;
    }
}
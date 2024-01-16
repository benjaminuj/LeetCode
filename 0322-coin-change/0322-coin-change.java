class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        return bfs(coins, amount);
    }
    
    public int bfs(int[] coins, int amount) {
        Queue<Info> q = new ArrayDeque<>();
        boolean[] visited = new boolean[amount+1];
        
        q.offer(new Info(0, amount));
        while (!q.isEmpty()) {
            Info now = q.poll();
        
            for (int i = 0; i < coins.length; i++) { 
                int nextAmount = now.amount - coins[i];
                if (nextAmount == 0) {
                    return now.coinCnt + 1;                     
                } else if (nextAmount > 0 && !visited[nextAmount]) {
                    q.offer(new Info(now.coinCnt + 1, nextAmount));
                    visited[nextAmount] = true;
                }
            }
        }
        return -1;
    }
}

class Info {
    int coinCnt;
    int amount;
    
    public Info(int coinCnt, int amount) {
        this.coinCnt = coinCnt;
        this.amount = amount;
    }
}
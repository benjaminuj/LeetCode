class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] answer = new int[amount+1];
        Arrays.fill(answer, 100000);
        for(int i =0; i < coins.length; i++) {
            if (coins[i] > amount) continue;
            answer[coins[i]] = 1;
        }
        answer[0] = 0;
        
        for (int coin : coins) {
            for (int i = 0; i < amount; i++) {
                if (answer[i] == 100000) continue;
                if (i+coin > amount) break;
                
                int temp = answer[i] + 1;
                if (answer[i+coin] == 100000) answer[i+coin] = temp;
                else {
                    answer[i+coin] = Math.min(temp, answer[i+coin]);
                }
            }
        }
        
        if (answer[amount] == 100000) return -1;
        return answer[amount];
    }
}
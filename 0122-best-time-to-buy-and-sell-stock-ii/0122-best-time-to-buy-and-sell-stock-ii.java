class Solution {
    public int maxProfit(int[] prices) {
        int[] diff = new int[prices.length];
        
        for (int i = 1; i <  prices.length; i++) {
            if (prices[i] - prices[i-1] < 0) {
                diff[i] = 0;
            } else {
                diff[i] = prices[i] - prices[i-1];
            }
        }
        
        return Arrays.stream(diff).sum();
    }
}
class Solution {
    int[] result;
    
    public int climbStairs(int n) {
        result = new int[n+1];
        Arrays.fill(result, -1);
        result[0] = 0;
        
        return back(n);
    }
    
    public int back(int n) {
        if (n == 1) {
            result[n] = 1;
        } else if (n == 2) {
            result[n] = 2;
        }
        
        if (result[n] == -1) {
            result[n] = back(n-1) + back(n-2);
        } 
        return result[n];

    }
}
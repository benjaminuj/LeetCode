class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int left = 0, right = height.length-1;
        int leftMax = height[left], rightMax = height[right];
        
        while(left <right) {
            if (leftMax <= rightMax) {
                left++;
                int curHeight = height[left];
                if (curHeight < leftMax) {
                    answer += leftMax - curHeight;
                } else {
                    leftMax = curHeight;
                }
            } else {
                right--;
                int curHeight = height[right];
                if (curHeight < rightMax) {
                    answer += rightMax - curHeight;
                } else {
                    rightMax = curHeight;
                }
            }
        }
        return answer;
    }
}
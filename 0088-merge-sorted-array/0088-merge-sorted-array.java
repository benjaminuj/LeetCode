class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] answer = new int[nums1.length];
        int idx = 0;
        
        while(p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                answer[idx++] = nums1[p1++]; 
            } else {
                answer[idx++] = nums2[p2++];
            }
        }
        
        while (p1 < m) {
            answer[idx++] = nums1[p1++];
        }
        
        while (p2 < n) {
            answer[idx++] = nums2[p2++];
        }
        System.arraycopy(answer, 0, nums1, 0, answer.length);
    }
}
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0; 
        }
        int cnt = 0; 
        int left = 0; 
        int prod = 1; 
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right]; 
            while (prod >= k) {
                prod /= nums[left]; 
                left++; 
            }
            cnt += right - left + 1; 
        }
        return cnt; 
    }
}
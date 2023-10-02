class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sol = Integer.MIN_VALUE;
        int sum = 0;
        int window = 0; 
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; 
            if (i >= k - 1) {
                sol = Math.max(sum, sol);
                sum -= nums[window++]; 
            }
        }
        return (double)sol/k; 
    }
}
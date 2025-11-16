class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sol = new int[nums.length];
        int[] prefixSum = new int[101];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[nums[i]]++;
            // [0, 1, 2, 1, 0, 0, 0, 0, 1]
        } 
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + prefixSum[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sol[i] = 0;
            } else {
                sol[i] = prefixSum[nums[i] - 1];
            }
        }
        return sol;
    }
}
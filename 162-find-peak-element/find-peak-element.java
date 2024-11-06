class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0; 
        int right = nums.length - 1; 
        while (left < right) {
            // prevents overflow when dealing with large arrays does the same thing as (left + right) / 2
            int middle = left + (right - left) / 2; 
            if (nums[middle] < nums[middle + 1]) {
                left = middle + 1; 
            } else { 
                right = middle; 
            }
        }
        return left; 
    }
}
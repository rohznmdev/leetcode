class Solution {
    public int search(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1; 
        while (left < right) {
            int middle = left + (right - left) / 2; 
            // we know that the nums[middle] < target so we can skip past everything from the left to the middle + 1 as we know target is not in that portion of the array. 
            if (nums[middle] < target) {
                left = middle + 1; 
            } else {
                // we know that nums[middle] > target so we need to exclude everything from the right side to the middle as it is bigger and target won't be in there. 
                right = middle; 
            }
        }
        if (nums[left] != target) return -1; 
        return left;
    }
}
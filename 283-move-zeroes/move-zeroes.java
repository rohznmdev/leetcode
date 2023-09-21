class Solution {
    public void moveZeroes(int[] nums) {
        int zeroes = 0; 
        for (int num: nums) {
            if (num != 0) {
                nums[zeroes] = num;
                zeroes++;
            }
        }
        while (zeroes < nums.length) {
            nums[zeroes] = 0;
            zeroes++;
        }
    }
}
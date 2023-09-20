class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> included = new HashSet<>(); 
        for (int num : nums) {
            included.add(num);
        }
        int missing = 0; 
        // [0, 1]
        for (int i = 0; i < nums.length + 1; i++) {
            if (!included.contains(i)) {
                missing = i;
            }
        }
        return missing; 
    }
}
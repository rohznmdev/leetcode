class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> sol = new HashSet<>(); 
        for (int i = 0; i < nums.length; i++) {
            sol.add(nums[i]); 
        }
        return !(sol.size() == nums.length); 
    }
}
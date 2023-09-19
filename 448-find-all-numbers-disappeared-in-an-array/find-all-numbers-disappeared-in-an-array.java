class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> allNums = new HashSet<>(); 
        List<Integer> sol = new ArrayList<>(); 
        for (int i = 0; i < nums.length; i++) {
            allNums.add(nums[i]);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!allNums.contains(i)) {
                sol.add(i);
            }
        }
        return sol; 
    }
}
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> sol = new ArrayList<>(); 
        Set<Integer> set = new HashSet<>(); 
        for (int num : nums) { 
            set.add(num); 
        }
        // [1, 2, 3, 4, 7, 8]
        for (int i = 1; i < nums.length + 1; i++) { 
            if (!set.contains(i)) sol.add(i);
        }
        return sol;
    }
}
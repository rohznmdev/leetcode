class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(); 
        int sol = 0; 
        for (Integer x : nums) {
            set.add(x); 
        }
        for (Integer x : set) {
            if (!set.contains(x - 1)) {
                int length = 1; 
                while (set.contains(x + length)) {
                    length++; 
                }
                sol = Math.max(length, sol); 
            }
        }
        return sol; 
    }
}
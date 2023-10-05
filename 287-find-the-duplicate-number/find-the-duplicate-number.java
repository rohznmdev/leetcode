class Solution {
    public int findDuplicate(int[] nums) {
        int sol = 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int x : map.keySet()) { 
            if (map.get(x) > 1) {
                sol = x; 
            }
        }
        return sol;
    }
}
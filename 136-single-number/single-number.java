class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int sol = 0; 
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // {1=1, 2=2}
        for (int x : map.keySet()) {
            if (map.get(x) < 2) {
                sol = x;
            }
        }
        return sol; 
    }
}
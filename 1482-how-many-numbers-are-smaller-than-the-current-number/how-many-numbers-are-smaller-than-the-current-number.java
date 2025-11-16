class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); 
        int[] temp = new int[nums.length];
        temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], i);
            }
        }
        int[] sol = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sol[i] = map.get(nums[i]);
        }
        return sol;
    }
}
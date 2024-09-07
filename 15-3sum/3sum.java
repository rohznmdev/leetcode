class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>(); 
        Arrays.sort(nums); 
        // [-4, -1, -1, 0, 1, 2]
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
            int j = i + 1; 
            int end = nums.length - 1; 
            while (j < end) {
                int total = nums[i] + nums[j] + nums[end]; 
                if (total > 0) {
                    end--; 
                } else if (total < 0) {
                    j++; 
                } else {
                    sol.add(Arrays.asList(nums[i], nums[j], nums[end]));
                    j++; 
                    while (j < end && nums[j] == nums[j - 1]) j++; 
                }
            }
        }
        return sol; 
    }
}
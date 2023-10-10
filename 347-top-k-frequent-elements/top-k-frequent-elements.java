class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] sol = new int[k]; 
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet()); 
        Collections.sort(list, (x, y) -> map.get(y) - map.get(x)); 
        for (int i = 0; i < k; i++) {
            sol[i] = list.get(i);
        }
        return sol; 
    }
}
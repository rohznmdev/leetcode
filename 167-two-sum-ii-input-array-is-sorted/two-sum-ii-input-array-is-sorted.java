class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int sol[] = new int[2]; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        // numbers = [2,7,11,15]
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) { 
                sol[0] = i + 1; 
                sol[1] = map.get(target - numbers[i]) + 1; 
                Arrays.sort(sol); 
                return sol; 
            }
            map.put(numbers[i], i); 
        }
        return new int[]{}; 
    }
}
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> sol = new ArrayList<>(); 
        int max = Integer.MIN_VALUE; 
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i]; 
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                sol.add(true);
            } else {
                sol.add(false);
            }
        }
        return sol;
    }
}
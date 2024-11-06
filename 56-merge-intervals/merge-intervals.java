class Solution {
    public int[][] merge(int[][] intervals) {
        // sort the intervals based on the starting index 
        // allows us to handle merging in a single pass
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); 
        List<int[]> sol = new ArrayList<>(); 
        int[] prev = intervals[0]; 
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i]; 
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]); 
            } else {
                // we know that the interval doesn't need changing, add the previous to the solution and change the prev to the current so we can evalute properly.
                sol.add(prev); 
                prev = curr; 
            }
        }
        sol.add(prev); 
        return sol.toArray(new int[sol.size()][]); 
    }
}
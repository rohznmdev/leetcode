class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); 
        List<int[]> sol = new ArrayList<>(); 
        int[] prev = intervals[0]; 
        for (int i = 1; i < intervals.length; i++) {
            // if start time of current interval is <= end time of prev interval -> merge
            int[] current = intervals[i]; 
            if (current[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], current[1]); 
            } else {
                // [1, 6], [8, 10]
                sol.add(prev); 
                prev = current; 
            }
        }
        sol.add(prev); 
        return sol.toArray(new int[sol.size()][]);
    }
}
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> sol = new ArrayList<>(); 
        int i = 0; 
        int j = 0; 
        while (i < firstList.length && j < secondList.length) {
            // intersection is the larger of the starting intervals
            // and smaller of the ending intervals
            int start = Math.max(firstList[i][0], secondList[j][0]); 
            int end = Math.min(firstList[i][1], secondList[j][1]); 
            // check if its an intersection 
            if (start <= end) sol.add(new int[]{start, end}); 
            // move forward in the list whose interval ends earlier
            if (firstList[i][1] < secondList[j][1]) {
                i++; 
            } else {
                j++; 
            }
        }
        return sol.toArray(new int[sol.size()][]); 
    }
}
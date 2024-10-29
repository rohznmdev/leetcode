class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
        {-1, -1}, {-1, 0}, {-1, 1}, 
        {0, -1}, {0, 1}, 
        {1, -1}, {1, 0}, {1, 1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length; 
        Queue<int[]> q = new LinkedList<>(); 
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1; 
        int[] start = new int[]{0, 0, 1}; 
        q.offer(start); 
        grid[0][0] = 1; 
        while (!q.isEmpty()) {
            int[] cell = q.poll(); 
            int row = cell[0]; 
            int col = cell[1]; 
            int distance = cell[2]; 
            if (row == n - 1 && col == n - 1) return distance; 
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0]; 
                int newCol = col + dir[1]; 
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    q.offer(new int[]{newRow, newCol, distance + 1}); 
                    grid[newRow][newCol] = 1; 
                }
            }
        }
        return -1; 
    }
}
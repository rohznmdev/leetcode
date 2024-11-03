class Solution {
    private int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1}, 
        {0, -1}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    }; 
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length; 
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        Queue<int[]> q = new LinkedList<>(); 
        // [row, col, dist]
        q.offer(new int[]{0, 0, 1}); 
        grid[0][0] = 1; 
        while (!q.isEmpty()) {
            int[] cell = q.poll(); 
            int row = cell[0]; 
            int col = cell[1]; 
            int dist = cell[2]; 
            if (row == n - 1 && col == n - 1) return dist; 
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0]; 
                int newCol = col + direction[1]; 
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    q.offer(new int[]{newRow, newCol, dist + 1}); 
                    grid[newRow][newCol] = 1; 
                }
            }
        }
        return -1; 
    }
}
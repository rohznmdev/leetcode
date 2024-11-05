class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(findDistance(b), findDistance(a))); 
        for (int[] point : points) {
            maxHeap.offer(point); 
            if (maxHeap.size() > k) {
                maxHeap.poll(); 
            }
        }
        int[][] sol = new int[k][2]; 
        for (int i = 0; i < k; i++) {
            sol[i] = maxHeap.poll(); 
        }
        return sol; 
    }

    private int findDistance(int[] point) {
        // returning the euclidean distance X1 - X2 + Y1 - Y2
        return point[0] * point[0] + point[1] * point[1]; 
    }
}
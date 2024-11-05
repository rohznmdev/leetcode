class Solution {
    private int[] cumulativeWeights; 
    private int totalWeight; 
    private Random random; 

    public Solution(int[] w) {
        cumulativeWeights = new int[w.length];
        totalWeight = 0; 
        random = new Random(); 
        // 1, 2, 3
        // 1, 3, 6
        // [1], [2, 3], [4, 5, 6]
        for (int i = 0; i < w.length; i++) {
            totalWeight += w[i]; 
            cumulativeWeights[i] = totalWeight; 
        } 
    }
    
    public int pickIndex() {
        int target = random.nextInt(totalWeight) + 1; 
        int left = 0; 
        int right = cumulativeWeights.length - 1; 
        
        while (left < right) {
            int middle = left + (right - left) / 2; 
            // if cumulativeWeights[middle] < target, we know the target lies in the right half and that the middle can be excluded.
            if (cumulativeWeights[middle] < target) {
                left = middle + 1; 
            } else {
                right = middle; 
            }
        }
        return left; 
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
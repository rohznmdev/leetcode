class SparseVector {
    private Map<Integer, Integer> map; 
    SparseVector(int[] nums) {
        map = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            // add the non-zero elements to the map for that vector
            // multiplying by zero doesn't contribute to the result and since a sparse vecotr is one that have mostly zero values we increase computational efficiency
            if (nums[i] != 0) map.put(i, nums[i]); 
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        // dot product 
        int sol = 0; 
        // go through all the entries of the calling vector 
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int index = entry.getKey(); 
            int value = entry.getValue(); 
            // if the parameter vector contains the calling vector index, we know that both vectors contain something non zero at that index so we can add that to the dot product. 
            // v1 = {0=1, 3=2, 4=3}
            // v2 = {1=3, 3=4}
            if (vec.map.containsKey(index)) sol += value * vec.map.get(index);
        }
        return sol; 
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
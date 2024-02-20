class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int j = 0; 
        for (int i = m; j < n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }
}
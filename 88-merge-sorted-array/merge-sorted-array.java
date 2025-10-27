class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1p = m - 1;
        int n2p = n - 1;
        int finalSortPoint = nums1.length - 1;
        
        while (n2p >= 0) {
            if (n1p >= 0 && nums1[n1p] > nums2[n2p]) {
                nums1[finalSortPoint] = nums1[n1p];
                finalSortPoint--; 
                n1p--; 
            } else {
                nums1[finalSortPoint] = nums2[n2p];
                finalSortPoint--;
                n2p--;
            }
        }
    }
}
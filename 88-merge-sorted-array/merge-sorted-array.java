class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1; 
        int sortPointer = nums1.length - 1; 
        while (nums1Pointer >= 0 && nums2Pointer >= 0) {
            if (nums1[nums1Pointer] < nums2[nums2Pointer]) {
                nums1[sortPointer] = nums2[nums2Pointer]; 
                sortPointer--; 
                nums2Pointer--; 
            } else {
                nums1[sortPointer] = nums1[nums1Pointer]; 
                nums1Pointer--; 
                sortPointer--; 
            }
        }
        while (nums2Pointer >= 0) {
            nums1[sortPointer] = nums2[nums2Pointer]; 
            nums2Pointer--; 
            sortPointer--; 
        }
    }
}
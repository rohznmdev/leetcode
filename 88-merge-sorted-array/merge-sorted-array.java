class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1Pointer = m - 1; 
        int n2Pointer = n - 1; 
        int sortPointer = nums1.length -1; 
        while (n1Pointer >= 0 && n2Pointer >= 0) {
            if (nums1[n1Pointer] < nums2[n2Pointer]) {
                nums1[sortPointer] = nums2[n2Pointer]; 
                sortPointer--; 
                n2Pointer--; 
            } else {
                nums1[sortPointer] = nums1[n1Pointer]; 
                sortPointer--; 
                n1Pointer--;
            }
        }
        // handles any remaining elements from nums2 that haven't been copied over
        // don't need to check cuz we know nums2 is sorted so we can just put them in nums1 at the next sort pointer position 
        // because nums1 has the length of both nums1 and nums2 there's a possibility that there's nothing in nums1 but something in nums2 that needs to be copied. this will take care of that.  
        while (n2Pointer >= 0) {
            nums1[sortPointer] = nums2[n2Pointer]; 
            n2Pointer--; 
            sortPointer--; 
        }
    }
}
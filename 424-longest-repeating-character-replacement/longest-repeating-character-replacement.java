class Solution {
    public int characterReplacement(String s, int k) {
        // create window that has minimum length k
        //
        int sol = 0; 
        int[] chars = new int[26]; 
        int maxLen = 0; 
        int start = 0; 
        for (int right = 0; right < s.length(); right++) {
            chars[s.charAt(right) - 'A']++; 
            maxLen = Math.max(maxLen, chars[s.charAt(right) - 'A']); 
            if (right - start + 1 - maxLen > k) {
                chars[s.charAt(start) - 'A']--; 
                start++; 
            }
            sol = Math.max(sol, right - start + 1); 
        }
        return sol; 
    }
}
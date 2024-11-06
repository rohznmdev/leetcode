class Solution {
    public boolean validPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1; 
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                /**
                if they are not equal we need to check if there is a substring that when removing a character forms a palinfrome
                left + 1 means we are removing the character at left by moving + 1 and keeping right the same
                right - 1 means we are removing the character at right by moving - 1 and keeping left the same
                we use or because we only need one of these modified strings to return true for us to have our answer
                 */
                return checkPalindrome(s, left + 1, right) || checkPalindrome(s, left, right - 1); 
            }
            left++; 
            right--; 
        }   
        return true; 
    }
    private boolean checkPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++; 
            high--; 
        }
        return true; 
    }
}
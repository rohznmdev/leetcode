class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true; 
        }
        int front = 0; 
        int back = s.length() - 1; 
        while (front <= back) {
            char frontS = s.charAt(front);
            char backS = s.charAt(back);
            if (!Character.isLetterOrDigit(frontS)) {
                front++;
            } else if (!Character.isLetterOrDigit(backS)) {
                back--;
            } else {
                if (Character.toLowerCase(frontS) != Character.toLowerCase(backS)) {
                    return false; 
                }
                front++;
                back--;
            }
        }
        return true;
    }
}
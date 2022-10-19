class Solution {
    public boolean isPalindrome(String s) {
        String temp = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (temp.isEmpty()) {
            return true;
        }
        int forward = 0; 
        int backward = temp.length() - 1;
        boolean ans = true;
        while (forward < backward) {
            if (temp.charAt(forward) != temp.charAt(backward)) {
                ans = false;
                break;
            }
            forward++;
            backward--;
        }
        return ans;
    }
}
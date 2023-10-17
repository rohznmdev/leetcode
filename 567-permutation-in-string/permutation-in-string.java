class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1chars = new int[26]; 
        int[] s2chars = new int[26]; 
        for (char x : s1.toCharArray()) {
            s1chars[x - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            s2chars[s2.charAt(i) - 'a']++;
            if (i >= s1.length()) {
                s2chars[s2.charAt(i - s1.length()) - 'a']--; 
            }
            if (Arrays.equals(s1chars, s2chars)) {
                return true; 
            }
        }
        return false;
    }
}
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0; 
        StringBuilder sol = new StringBuilder(); 
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                sol.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sol.append(word2.charAt(i));
            }
            i++; 
        }
        return sol.toString(); 
    }
}
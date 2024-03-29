class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sol = new StringBuilder();
        Arrays.sort(strs); 
        for (int i = 0; i < Math.min(strs[0].length(), strs[strs.length - 1].length()); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                return sol.toString(); 
            }
            sol.append(strs[0].charAt(i));
        }
        return sol.toString(); 
    }
}
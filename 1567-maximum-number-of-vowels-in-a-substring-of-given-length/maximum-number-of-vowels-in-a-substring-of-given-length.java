class Solution {
    public int maxVowels(String s, int k) {
        int left = 0; 
        int sol = Integer.MIN_VALUE; 
        int cnt = 0; 
        for (int right = 0; right < s.length(); right++) {
            if (isVowel(s.charAt(right))) {
                cnt++;
            }
            if (right - left >= k - 1) {
                if (cnt > sol) {
                    sol = cnt; 
                }
                if (isVowel(s.charAt(left))) {
                    cnt--; 
                }
                left++; 
            }
        }
        return sol; 
    }

    public boolean isVowel(Character c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false; 
        }
    }
}
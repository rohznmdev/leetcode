class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>(); 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '*') {
                stack.pop();
            }
        }
        StringBuilder sol = new StringBuilder(); 
        for (char c : stack) {
            sol.append(c);
        }
        return sol.toString();
    }
}
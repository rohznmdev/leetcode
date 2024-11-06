class Solution {
    public String minRemoveToMakeValid(String s) {
        // first pass removes invalid closing parenthesis ')' but leaves any unmatched opening parenthesis
        StringBuilder result = remove(s, '(', ')'); 
        // for second pass we reverse the result of the first pass allowing us to treat unmatched opening parenthesis '(' as if they were closing parenthesis. 
        result = remove(result.reverse(), ')', '('); 
        return result.reverse().toString(); 
    }
    private StringBuilder remove(CharSequence s, char open, char close) {
        int balance = 0; 
        StringBuilder sol = new StringBuilder(); 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == open) {
                balance++;
            } else if (s.charAt(i) == close) {
                if (balance == 0) continue; 
                balance--; 
            }
            sol.append(s.charAt(i)); 
        }
        return sol; 
    }
}
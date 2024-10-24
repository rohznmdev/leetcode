class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>(); 
        Set<Integer> set = new HashSet<>(); 
        StringBuilder sol = new StringBuilder(); 
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i); 
            if (currChar == '(') {
                st.push(i); 
            } else if (currChar == ')') {
                if (!st.isEmpty()) {
                    st.pop(); 
                } else {
                    set.add(i); 
                }
            }
        }
        // we have extra '('
        while (!st.isEmpty()) {
            set.add(st.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sol.append(s.charAt(i));
            }
        }
        return sol.toString();
    }
}
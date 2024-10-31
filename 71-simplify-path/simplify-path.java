class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>(); 
        String[] arr = path.split("/"); 
        // path = "/home/user/Documents/../Pictures"
        // home, user, Documents, .., Pictures
        for (String s : arr) {
            if (s.equals("..") && !st.isEmpty()) {
                st.pop(); 
            } else if (!s.equals(".") && !s.equals("..") && !s.equals("")) {
                st.push(s); 
            }
        }
        return "/" + String.join("/", st); 
    }
}
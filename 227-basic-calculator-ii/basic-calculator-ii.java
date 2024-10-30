class Solution {
    public int calculate(String s) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> opr = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n = n * 10 + (s.charAt(i) - '0');
                    i++;
                }
                val.push(n);
                i--;
            } else if (ch == '+' || ch == '-') {
                while (!opr.isEmpty()) {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    char op = opr.pop();
                    if (op == '*') val.push(v1 * v2);
                    else if (op == '/') val.push(v1 / v2);
                    else if (op == '+') val.push(v1 + v2);
                    else val.push(v1 - v2);
                }
                opr.push(ch);
            } else if (ch == '*' || ch == '/') {
                if (!opr.isEmpty() && (opr.peek() == '*' || opr.peek() == '/')) {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    char op = opr.pop();
                    if (op == '*') val.push(v1 * v2);
                    else val.push(v1 / v2);
                }
                opr.push(ch);
            }
        }
        while (!opr.isEmpty()) {
            int v2 = val.pop();
            int v1 = val.pop();
            char op = opr.pop();
            if (op == '*') val.push(v1 * v2);
            else if (op == '/') val.push(v1 / v2);
            else if (op == '+') val.push(v1 + v2);
            else val.push(v1 - v2);
        }
        return val.peek();
    }
}
class Solution {
    public String restoreString(String s, int[] indices) {
        HashMap<Integer, Character> map = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++) {
            map.put(indices[i], s.charAt(i));
        }
        // codeleet -> {4=c, 5=o, 6=d, 7=e, 0=l, 2=e, 1=e, 3=t}
        StringBuilder sol = new StringBuilder(); 
        for (Integer x : map.keySet()) {
            sol.append(map.get(x));
        }
        return sol.toString();
    }
}
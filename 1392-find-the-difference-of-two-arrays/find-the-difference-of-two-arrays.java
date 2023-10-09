class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> num1 = new HashSet<>();
        HashSet<Integer> num2 = new HashSet<>();
        for (int x : nums1) {
            num1.add(x);
        }
        for (int x : nums2) {
            num2.add(x);
        }
        List<List<Integer>> sol = new ArrayList<>(); 
        HashSet<Integer> temp = new HashSet<>(); 
        for (int x : num1) {
            if (!num2.contains(x)) temp.add(x);
        }
        sol.add(new ArrayList<>(temp));
        temp = new HashSet<>(); 
        for (int x : num2) {
            if (!num1.contains(x)) temp.add(x);
        }
        sol.add(new ArrayList<>(temp));
        return sol; 
    }
}
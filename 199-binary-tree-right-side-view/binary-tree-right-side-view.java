/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sol = new ArrayList<>(); 
        dfs(root, sol, 0); 
        return sol; 
    }
    private void dfs(TreeNode root, List<Integer> list, int depth) {
        if (root == null) return; 
        // list.size() keeps track of how many levels we have encountered
        // if depth == list.size() this is our first time encountering this depth level
        // add root.val to the list as this is the rightmost node for that depth level. 
        // start dfs on the right side and then go to the left 
        if (depth == list.size()) list.add(root.val); 
        dfs(root.right, list, depth + 1); 
        dfs(root.left, list, depth + 1); 
    }
}
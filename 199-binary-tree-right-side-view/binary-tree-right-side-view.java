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
    private List<Integer> sol = new ArrayList<>(); 
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, sol, 0); 
        return sol; 
    }
    private void dfs(TreeNode node, List<Integer> list, int depth) {
        if (node == null) return; 
        if (depth == sol.size()) {
            sol.add(node.val); 
        }
        dfs(node.right, sol, depth + 1); 
        dfs(node.left, sol, depth + 1); 
    }
}
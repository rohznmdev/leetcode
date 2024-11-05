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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // map maps column to the nodes in that column
        Map<Integer, List<Integer>> map = new TreeMap<>(); 
        // pair<node, col> 
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>(); 
        if (root != null) q.offer(new Pair<>(root, 0)); 
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> curr = q.poll(); 
            TreeNode node = curr.getKey(); 
            int col = curr.getValue(); 
            map.putIfAbsent(col, new ArrayList<>()); 
            map.get(col).add(node.val);
            if (node.left != null) q.offer(new Pair<>(node.left, col - 1)); 
            if (node.right != null) q.offer(new Pair<>(node.right, col + 1)); 
        }
        return new ArrayList<>(map.values()); 
    }
}
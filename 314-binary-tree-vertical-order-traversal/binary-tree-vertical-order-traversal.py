# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        # Dictionary to hold nodes in each column
        column_table = defaultdict(list)
        # Queue for BFS; stores tuples of (node, column_index)
        queue = deque([(root, 0)])
        
        # Perform BFS traversal
        while queue:
            node, col = queue.popleft()
            if node:
                # Add the node's value to the list of its respective column index
                column_table[col].append(node.val)
                # Queue the left and right children with updated column indices
                queue.append((node.left, col - 1))
                queue.append((node.right, col + 1))
        
        # Sort the columns and retrieve the nodes in column order
        return [column_table[x] for x in sorted(column_table.keys())]
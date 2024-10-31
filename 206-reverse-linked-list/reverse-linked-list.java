/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; 
        ListNode curr = head; 
        // null <- 1  2 -> 3 -> 4 -> 5
        while (curr != null) {
            ListNode temp = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = temp; 
        }
        return prev; 
    }
}
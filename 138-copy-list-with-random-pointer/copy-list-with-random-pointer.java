/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null; 
        // original node is the key and a new node for the deep copy is added with the same value as the value
        Map<Node, Node> map = new HashMap<>(); 
        Node curr = head; 
        while (curr != null) {
            map.put(curr, new Node(curr.val)); 
            curr = curr.next;
        }
        curr = head; 
        /**
        HashMap: {
        Node(3): Node(3),
        Node(9): Node(9),
        Node(20): Node(20),
        Node(15): Node(15),
        Node(7): Node(7)
        } */
        while (curr != null) {
            map.get(curr).next = map.get(curr.next); 
            map.get(curr).random = map.get(curr.random); 
            curr = curr.next; 
        }
        return map.get(head); 
    }
}
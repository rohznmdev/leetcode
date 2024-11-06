class LRUCache {

    private class Node { 
        int key, value; 
        Node prev, next; 

        Node(int key, int value) { 
            this.key = key; 
            this.value = value; 
        }
    }

    private final HashMap<Integer, Node> map; 
    private final int capacity; 
    private final Node head, tail; 

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        this.map = new HashMap<>(); 
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        head.next = tail; 
        tail.prev = head;     
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1; 
        Node node = map.get(key); 
        remove(node); 
        insert(node); 
        return node.value; 
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key)); 
        }
        if (map.size() == capacity) {
            remove(tail.prev); 
        }
        Node newNode = new Node(key, value); 
        insert(newNode); 
    }
    // node is removed from the map breaking any references from the map to the node
    // nodes prev and next pointers are updated to bypass it so it removes any connections in the linked list. 
    private void remove(Node node) {
        map.remove(node.key); 
        node.prev.next = node.next; 
        node.next.prev = node.prev; 
    }
    private void insert(Node node) {
        map.put(node.key, node); 
        // sets the next pointer of the node to the current first element inthe list 
        node.next = head.next; 
        // sets the prev pointer of the node to the head making it the new first element in the list
        node.prev = head; 
        // updates the prev first elements prev back to the newly inserted node
        head.next.prev = node; 
        // completes insertion by setting head.next to point to the new node.
        head.next = node; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
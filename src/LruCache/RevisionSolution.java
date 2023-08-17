package LruCache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        private Node next;
        private Node prev;
        private final int key;
        private final int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<Integer, Node> map = new HashMap<>();

    private Node head = new Node(-1, -1);
    private Node tail = new Node( -1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if ( ! map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        Node newNode = new Node(key, node.value);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {

        // if the key is already there, then it wont
        // exceed capacity, so we dont do capacity check here.
        if ( map.containsKey(key)) {
            Node existing = map.get(key);
            // remove this node.
            removeNode(existing);
            // add a new node on top of the list and update the map.
            Node newNode = new Node(key, value);
            addNode(newNode);
            return;
        }



        // two cases to handle here
        // capacity exceeded
        // with in capacity

        if ( map.size() == capacity) {
            // we must evict the least used key.
            this.removeNode(tail.prev);
        }

        // insert the node and update map.
        Node newNode = new Node(key, value);
        addNode(newNode);


    }

    private void addNode(Node node) {
        // head <-> 1 <-> node_to_be_inserted <-> tail

        // we are saving the head next, because we want to place this
        // node before it.
        Node next = head.next;

        // set the head pointer to new node
        head.next = node;

        // reassign nodes pointers
        node.prev = head;
        node.next = next;

        // set the prev of node which moved below
        next.prev = node;

        // also update the map.
        map.put(node.key, node);
    }

    private void removeNode(Node nodeToBeRemoved) {
        // head <-> 1 <-> 2 <-> 3 <-> tail
        // here we get 2 node and set
        // next of 1 node to 3
        // then set prev of 3 to 1
        Node prev = nodeToBeRemoved.prev; // 1
        Node next = nodeToBeRemoved.next; // 3
        prev.next = next; // 1 -> 3
        next.prev = prev; // 3 -> 1

        // also remove the key from map
        map.remove(nodeToBeRemoved.key);
    }
}

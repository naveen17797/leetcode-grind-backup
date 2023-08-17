import java.util.HashMap;
import java.util.Map;

class LRUCache {


    public Node head = new Node(-1, -1);
    public Node tail = new Node(-1, -1);


    class Node {
        public Node next;
        public Node prev;
        public int key;
        public int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private void deleteNode(Node p) {
        Node pre = p.prev;
        Node nex = p.next;
        pre.next = nex;
        nex.prev = pre;
    }

    private void addNode(Node newnode) {
        Node temp = head.next;
        head.next = newnode;
        newnode.prev = head;
        newnode.next = temp;
        temp.prev = newnode;
    }
    public Map<Integer, Node> map = new HashMap<>();


    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        deleteNode(n);
        map.remove(key);
        addNode(n);
        map.put(key, n);
        return n.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n1 = map.get(key);
            deleteNode(n1);
            Node n2 = new Node(key, value);
            addNode(n2);
            map.put(key, n2);
        }
        else {
            if (map.size() == capacity) {
                Node last = tail.prev;
                deleteNode(last);
                map.remove(last.key);
                Node n2 = new Node(key, value);
                addNode(n2);
                map.put(key, n2);
            }
            else {
                Node n = new Node(key, value);
                addNode(n);
                map.put(key, n);
            }
        }
    }
}
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;





class AllOne {

    class Node {
        public Node next;
        public Node prev;
        public int count;
        public Set<String> keys = new HashSet<>();


        public Node(int count) {
            this.count = count;
        }

    }
    public Node head = new Node(0);
    public Node tail = new Node(0);
    public Map<String, Node> map = new HashMap<>();


    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }

    public void addNewNode(Node ref, String key, int count) {
        Node newNode = new Node(1);
        newNode.keys.add(key);
        map.put(key, newNode);
        Node tmp = ref.next;
        ref.next = newNode;
        newNode.prev = ref;
        newNode.next = tmp;
        tmp.prev = newNode;
    }

    public void inc(String key) {

        if ( ! map.containsKey(key) ) {
            // If the key doesnt exist then we should check if
            // the node with count 1 exist, if it dont we need to add the node.
            // we can reuse the existing node and add the key there.
            if (head.next.count == 1) {
                head.next.keys.add(key);
                map.put(key, head.next);
            }
            else {
                // it doesnt exist, so add the node below head.
                addNewNode(head, key, 1);
            }
        }
        else {
            // The key exist, then we have to find the node
            // get the node, see if the incremented node exists
            // if yes add it, or else create new node.
            Node existing = map.get(key);

            // The count node exists, then we just pull the key from here and
            // put it there.
            if (existing.count + 1 == existing.next.count ) {
                existing.next.keys.add(key);
                existing.keys.remove(key);
            }
            else {
                // the count node must be inserted with incremented count.
                addNewNode(existing, key, existing.count + 1);
            }

            if ( existing.keys.isEmpty()) {
                // the node has no keys, so we need to remove it.
                deleteNode(existing);
            }

        }

    }

    private void deleteNode(Node existing) {
        Node prev = existing.prev;
        Node next = existing.next;
        prev.next = next;
        next.prev = prev;
    }


    public void dec(String key) {

        if ( map.containsKey(key)) {

            Node existing = map.get(key);

            // conditions to apply
            // if the count is going to be zero and single element in the list it needs to be removed
            // if the count is going to be a positive value then check if the node is in prev, if not then
            // add it

            if (existing.count == 1) {
                // we can simply remove the item
                existing.keys.remove(key);
                map.remove(key);
            } else {
                if (existing.count - 1 == existing.prev.count) {
                    // previous node exists, then we just remove value from here and add it.
                    existing.keys.remove(key);
                    existing.prev.keys.add(key);
                    map.remove(key);
                } else {
                    addNewNode(existing.prev, key, existing.count - 1);
                }
            }


            if (existing.keys.isEmpty()) {
                deleteNode(existing);
            }
        }

    }

    public String getMaxKey() {

        if ( tail.prev == head) {
            return "";
        }

        if ( tail.prev != null ) {
            return tail.prev.keys.iterator().next();
        }
        return "";
    }

    public String getMinKey() {
        if ( head.next == tail) {
            return "";
        }

        if ( head.next != null) {
            return head.next.keys.iterator().next();
        }
        return "";
    }
}

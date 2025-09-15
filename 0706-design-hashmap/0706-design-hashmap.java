class MyHashMap {

    static class Node {
        int key, val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] nodes = new Node[1000000];

    public MyHashMap() {
        
    }

    public void put(int key, int value) {
        int index = key % nodes.length;

        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }

        Node node = nodes[index];
        Node lastNode = null;

        while (node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            lastNode = node;
            node = node.next;
        }

        lastNode.next = new Node(key, value);
    }

    public int get(int key) {
        int index = key % nodes.length;
        Node node = nodes[index];

        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = key % nodes.length;
        Node head = nodes[index];

        if (head == null) {
            return;
        }

        if (head.key == key) {
            nodes[index] = head.next;
            return;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
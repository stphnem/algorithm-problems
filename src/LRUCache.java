/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/#/description
 *
 */

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node() {}
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head, tail;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }
 
    public int get(int key) {
       if (map.containsKey(key)) {
           Node node = map.get(key);
           this.moveToHead(node);
           return node.value;
       }
       
       return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            this.moveToHead(node);
        } else {
            node = new Node(key, value);
            if (map.size() >= capacity) {
                this.popTail();
            }
            this.addNode(node);
        }
    }

    public Node popTail() {
        Node remove = tail.pre;
        this.removeNode(remove);
        return remove;
    }

    public void moveToHead(Node node) {
        this.removeNode(node);
        this.addNode(node);
    }

    public void removeNode(Node node){
        map.remove(node.key);
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    public void addNode(Node node) {
        map.put(node.key, node);
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }
}
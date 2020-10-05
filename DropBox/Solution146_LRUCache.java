package DropBox;

import java.util.HashMap;

public class Solution146_LRUCache {

    HashMap<Integer, Node> hashMap;
    int size = 0;
    int capacity;
    Node head;
    Node tail;

    public Solution146_LRUCache(int capacity) {
        hashMap = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head = null;
        tail = null;

    }

    public int get(int key) {
        int result = -1;
        /**
         * if hashMap contains the key get Node -> update sorroundings -> update head if
         * hashMap not contain key -> return -1;
         * 
         */
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            updateSorroudings(node);
            addAtBeginning(node);
            result = node.value;
        }

        return result;
    }

    private Node addAtBeginning(Node node) {
        if (node == head)
            return node;
        // while (head.prev != null)
        // tail = tail.prev;
        // Node temp = head;
        if (head != null)
            head.next = node;
        node.prev = head;
        node.next = null;
        head = node;
        hashMap.put(node.key, node);
        return node;
    }

    private void removeFromEnd() {
        hashMap.remove(tail.key);
        Node temp = tail.next;
        if (temp != null)
            temp.prev = null;
        tail = temp;
    }

    public void put(int key, int value) {
        // if it contains the key return the Node, update the value
        Node node;
        if (hashMap.containsKey(key)) {
            node = hashMap.get(key);
            node.value = value;
            updateSorroudings(node);
        }
        // doesn't contain key
        else {
            // if size == capacity, removeLastNode(), create new Node
            if (size == capacity) {
                removeFromEnd();
                size--;
            }

            node = new Node();
            node.key = key;
            node.value = value;
            // may be tail == null should go here!
            size++;
        }
        // update the head, update the hashMap
        node = addAtBeginning(node);
        hashMap.put(key, node);

        if (tail == null) {
            tail = node;
        }

    }

    private void updateSorroudings(Node node) {
        Node prevNode = node.prev;
        Node nexNode = node.next;
        // single Node
        if (head == node) {
            // no need to change the order
            return;
        }
        // update tail
        else if (tail == node) {
            removeFromEnd();
        } else {
            if (prevNode != null) {
                prevNode.next = nexNode;
            }
            if (nexNode != null) {
                nexNode.prev = prevNode;
            }
        }

    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

    }

    public static void main(String[] args) {
        Solution146_LRUCache cache = new Solution146_LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        System.out.println(cache.get(2)); // 1
        cache.put(4, 1);
        System.out.println(cache.get(1)); // -1
        // cache.put(4, 4);
        System.out.println(cache.get(2)); // 1
        // System.out.println(cache.get(3));
        // System.out.println(cache.get(4));
        // Solution146_LRUCache cache = new Solution146_LRUCache(1);
        // cache.put(2, 1);
        // // cache.put(2, 2);
        // System.out.println(cache.get(2));
        // cache.put(3, 2);
        // System.out.println(cache.get(2));
        // // cache.put(4, 4);
        // System.out.println(cache.get(3));
        // System.out.println(cache.get(3));
        // System.out.println(cache.get(4));
        //
    }

}
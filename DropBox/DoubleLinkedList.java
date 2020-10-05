package DropBox;

public class DoubleLinkedList {
    Node head;
    Node tail;

    DoubleLinkedList() {
        head = null;
        tail = null;
    }

    void add(int num) {
        Node node = new Node(num);
        node.prevNode = head;
        if (head != null) {
            head.nextNode = node;
        } else if (head == null) {
            tail = node;
        }
        head = node;
    }

    void remove() {
        if (head == null || tail == null)
            return;
        // first node
        if (head == tail) {
            head = null;
            tail = null;

        } else {
            Node newEnd = tail.nextNode;
            newEnd.prevNode = null;
            tail = newEnd;
        }
    }

    void updateNode(Node node) {
        Node prevNode = node.prevNode;
        Node nextNode = node.nextNode;

        if (node == tail)
            tail = nextNode;
        if (node == head)
            head = prevNode;
        if (nextNode != null)
            nextNode.prevNode = prevNode;
        if (prevNode != null)
            prevNode.nextNode = nextNode;

    }

    class Node {
        int value;
        Node prevNode;
        Node nextNode;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.remove();
        linkedList.add(5);

        System.out.println(linkedList);
    }
}
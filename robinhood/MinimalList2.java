package robinhood;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinimalList2 {
    public static void main(String[] args) {
        MinimalList2 mi = new MinimalList2();
        int n[] = { 2, 7, 8, 5, 1, 6, 3, 9, 4 };
        List<Integer> list = mi.minimalList(n);
        System.out.println(" ");
        for (int a : list) {
            System.out.println(a);
        }

    }

    List minimalList(int[] n) {
        Node head = createDoublyLinkedList(n);
        TreeSet<Node> treeSet = new TreeSet<Node>(new MyCompartor());
        List<Integer> result = new ArrayList<>();

        while (head != null) {
            if (valuesNearbyAreSmaller(head)) {
                treeSet.add(head);
            }
            head = head.nextNode;
        }
        // while treeSet .size >0
        // pop the value from treeSet and head
        // add the value to the result
        // update the prev and next nodes of the
        // for the value, check if the elements around have smaller numbers,
        // if they do add them to the treeSet
        //
        while (treeSet.size() > 0) {
            Node minNode = treeSet.first();
            Node prevNode = minNode.prevNode;
            Node nextNode = minNode.nextNode;
            if (prevNode != null)
                prevNode.nextNode = nextNode;
            if (nextNode != null)
                nextNode.prevNode = prevNode;

            // System.out.println(minNode.value);
            result.add(minNode.value);
            treeSet.pollFirst();

            if (valuesNearbyAreSmaller(prevNode)) {
                treeSet.add(prevNode);
            }
            if (valuesNearbyAreSmaller(nextNode)) {
                treeSet.add(nextNode);
        }

        return result;
    }

    private boolean valuesNearbyAreSmaller(Node head) {
        if (head == null)
            return false;
        int prevData = head.prevNode != null ? head.prevNode.value : 0;
        int currentData = head.value;
        int nextData = head.nextNode != null ? head.nextNode.value : 0;
        if (currentData > prevData && currentData > nextData)
            return true;
        else
            return false;
    }

    Node createDoublyLinkedList(int[] n) {
        Node head = null, tail = null;
        for (int i = 0; i < n.length; i++) {
            Node newNode = new Node(n[i]);
            if (head == null) {
                head = tail = newNode;
                head.prevNode = null;
                tail.nextNode = null;
            } else {
                tail.nextNode = newNode;
                newNode.prevNode = tail;
                tail = newNode;
                tail.nextNode = null;

            }
        }
        return head;
    }

    class Node {
        Node prevNode;
        Node nextNode;
        int value;

        Node(int n) {
            this.value = n;
        }
    }

    class MyCompartor implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.value > o2.value ? 1 : -1;
        }

    }
}

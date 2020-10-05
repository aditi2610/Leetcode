package RepeatThese;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    Map<Integer, Node> map = new HashMap<Integer, Node>();

    class Node {
        Node parent;
        int value;
        int rank;

        Node(int value) {
            this.value = value;
            this.rank = 0;
        }
    }

    void makeSet(int n) {
        Node node = new Node(n);
        node.parent = node;
        map.put(n, node);
    }

    void union(int a, int b) {
        Node parentA = findSet(a);
        Node parentB = findSet(b);
        if (parentA == parentB) {
            // do nothing
        } else {
            // find the rank of the parents
            // if parents1 has higher rank,
            // take parent1 and make it parent for the other one
            if (parentA.rank >= parentB.rank) {
                parentA.rank = parentA.rank == parentB.rank ? parentA.rank + 1 : parentA.rank;
                parentB.parent = parentA;
            } else {
                parentA.parent = parentB;
            }

            // else
            // take parent2 and make it the parent of the parent1
        }
    }

    /**
     * this method will tell you the absolute parent
     * 
     * @param a
     * @return
     */
    Node findSet(int a) {
        // assuming its always a valid operation
        Node parent = map.get(a).parent;

        if (parent == parent.parent)
            return parent;
        else {
            parent.parent = findSet(parent.value);
            return findSet(parent.value);
        }

    }

    int find(int n) {
        return findSet(n).value;
        // return 0;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        uf.makeSet(1);
        uf.makeSet(2);
        uf.makeSet(3);
        uf.makeSet(4);
        uf.makeSet(5);
        uf.makeSet(6);
        uf.makeSet(7);

        uf.makeSet(11);
        uf.makeSet(12);
        uf.makeSet(13);
        uf.makeSet(14);

        uf.union(1, 2);
        uf.union(1, 3);
        uf.union(3, 6);
        uf.union(1, 4);
        uf.union(2, 5);
        uf.union(5, 7);

        uf.union(11, 12);
        uf.union(11, 13);
        uf.union(12, 14);
        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
        System.out.println(uf.find(3));
        System.out.println(uf.find(5));
        System.out.println(uf.find(6));
        System.out.println(uf.find(7));

        System.out.println();
        System.out.println(uf.find(11));
        System.out.println(uf.find(12));
        System.out.println(uf.find(13));
        System.out.println(uf.find(14));

    }
}

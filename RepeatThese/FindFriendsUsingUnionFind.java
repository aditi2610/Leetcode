package RepeatThese;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindFriendsUsingUnionFind {

    int findCircleNum(int[][] M) {
        int[] parentIndices = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parentIndices[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(i, j, parentIndices);
                }
            }
        }

        for (int i = 0; i < parentIndices.length; i++) {
            System.out.println(parentIndices[i]);
        }
        Set<Integer> set = new HashSet<>();
        int max = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < parentIndices.length; i++) {
        // int val = map.getOrDefault(findParent(i, parentIndices), 1);
        // map.put(findParent(i, parentIndices), val);
        // if (max < val) {
        // max = val;
        // }
        // }
        System.out.println(" max: " + max);
        return set.size();
    }

    void union(int i, int j, int[] parentIndices) {
        int parentA = findParent(i, parentIndices);
        int parentB = findParent(j, parentIndices);
        if (parentA != parentB) {
            if (i > j)
                parentIndices[parentA] = parentB;
            else
                parentIndices[parentB] = parentA;

        }

    }

    private int findParent(int i, int[] parentIndices) {
        if (parentIndices[i] == i)
            return i;
        else {
            parentIndices[i] = findParent(parentIndices[i], parentIndices);
            return parentIndices[i];
        }

    }
    // public int findCircleNum(int[][] M) {
    // int n = M.length;

    // // Step1 : Created array to maintain parent of each node
    // int[] uf = new int[n];
    // // This step will update with self index as parent.
    // for (int i = 0; i < n; i++)
    // uf[i] = i;
    // // Step2 : Finding and updating parentif the nodes are connected with each
    // other
    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < n; j++) {
    // if (M[i][j] == 1 && i != j) {
    // union(i, j, uf);
    // }
    // }
    // }
    // // Step3 : Set will find the parent of each node and size of the set returns
    // the
    // // answer
    // for (int i : uf)
    // System.out.println(i);
    // Set<Integer> set = new HashSet<>();
    // for (int i = 0; i < n; i++)
    // set.add(find(i, uf));
    // return set.size();
    // }

    // // Union method updates the index of parent
    // public void union(int i, int j, int[] uf) {
    // int parent1 = find(i, uf);
    // int parent2 = find(j, uf);
    // uf[parent1] = parent2;
    // }

    // // Find method will find the parent at each index.
    // public int find(int edge, int[] uf) {
    // if (uf[edge] != edge) {
    // return find(uf[edge], uf);
    // }
    // return uf[edge];
    // }

    public static void main(String[] args) {
        FindFriendsUsingUnionFind find = new FindFriendsUsingUnionFind();
        // int[][] M = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 }
        // };
        int[][] M = { { 1, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 } };
        System.out.println(find.findCircleNum(M));
    }
}

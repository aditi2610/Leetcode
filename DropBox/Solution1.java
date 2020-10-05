package DropBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution1 {

    public static int maxBalancedTeams(List<Integer> developers, int maxNewHires) {
        // Write your code here
        // some teams
        // each team has some developers + developers
        // create a map and put the number of developers in the team in that map
        // sorted Map so to store the value
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int finalC = 0;
        int maxValue = 0;
        int highestFreq = 0;
        for (Integer i : developers) {
            int count = (int) map.getOrDefault(i, 0) + 1;
            if (count > maxValue) {
                maxValue = count;
                highestFreq = i;

            }
            map.put(i, count);
        }

        for (int d : developers) {
            if (d < highestFreq) {
                finalC++;
            }
        }

        return finalC;

    }

    public List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        // calculate count. = d%arr.length;
        /**
        *
         *
        **/
        int count = d % arr.size();
        int size = arr.size();
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(arr);
        for (int i = 0; i < size; i++) {
            int newIndex = (size - count + i) % size;
            list.set(newIndex, arr.get(i));
        }
        return list;

    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(sol.rotateLeft(2, list));
        String a = "aditi".substring(5, 0);
        System.out.println(a);
    }
}

package robinhood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {
    public static void main(String[] args) {
        Pairs pairs = new Pairs();
        int[][] an = { { 3, 5 }, { 1, 4 }, { 2, 4 }, { 1, 5 } };

        int[] n = pairs.createArray(an);

        for (int i : n) {
            System.out.println(i);
        }
    }

    int[] createArray(int[][] pairs) {
        int[] ans = new int[pairs.length + 1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> set = new ArrayList<Integer>();
        Set<Integer> checkSet = new HashSet<>();
        for (int[] pair : pairs) {
            int a = pair[0];
            int b = pair[1];

            List list1 = map.getOrDefault(a, new ArrayList<>());
            list1.add(b);
            map.put(a, list1);
            List list2 = map.getOrDefault(b, new ArrayList<>());
            list2.add(a);
            map.put(b, list2);

            if (set.contains(a))
                set.remove(a);
            else
                set.add(a);

            if (set.contains(b))
                set.remove(b);
            else
                set.add(b);
            // for a add b to the list

            // for b add a to the list
            // create a set and store both a and b as the starting elements
            // if set already contains the element remove them
        }
        // take the element from the set
        // now dfs
        int startingElement = set.get(0);
        dfs(startingElement, map, ans, checkSet, 0);
        // get the list from map for starting element,
        //
        return ans;
    }

    private void dfs(int startingElement, HashMap<Integer, List<Integer>> map, int[] ans, Set<Integer> checkSet,
            int i) {

        if (!checkSet.contains(startingElement)) {
            ans[i] = startingElement;
            checkSet.add(startingElement);
            List<Integer> list = map.get(startingElement);
            // 3
            for (int j = 0; j < list.size(); j++) {
                dfs(list.get(j), map, ans, checkSet, i + 1);
            }

        }

    }
}

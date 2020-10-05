package general;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution_maxSumClosest {
    public int getLargestSumCloseToK(int[] inputs, int k) {
        int opt = 0;
        Set<Integer> sums = new HashSet<>();
        sums.add(opt);

        // loop over all input values
        for (Integer input : inputs) {
            Set<Integer> newSums = new HashSet<>();

            // loop over all sums so far
            for (Integer sum : sums) {
                int newSum = sum + input;

                // ignore too big sums
                if (newSum <= k) {
                    newSums.add(newSum);

                    // update optimum
                    if (newSum > opt) {
                        opt = newSum;
                    }
                }
            }

            sums.addAll(newSums);
        }

        return opt;
    }

    public static void main(String[] args) {
        Solution_maxSumClosest max = new Solution_maxSumClosest();
        int[] ar = { 4, 8, 5, 9 };
        System.out.println(max.getLargestSumCloseToK(ar, 20));

    }
}
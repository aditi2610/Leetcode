package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution39_CombinationSum {

    public static void main(String[] args) {
        Solution39_CombinationSum combSum = new Solution39_CombinationSum();
        int[] cand = { 2, 3, 6, 7 };
        //[2,7,6,3,5,1]
9
        List<List<Integer>> list = combSum.combinationSum(cand, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        /**
         * 
         * base case: if the target is less than the starting index return; if the
         * target is equal to the starting index add tempList to the main list for each
         * iteration create a new list -> tempList for each index startign 0 subtract
         * the index Val- target and pass it on with new target 2367
         */

        Arrays.sort(candidates);
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        findSum(0, candidates, target, finalList, new ArrayList<>());

        System.out.println("Final List : " + finalList);
        return finalList;
    }

    // i ==2 target =
    private void findSum(int i, int[] candidates, int target, List<List<Integer>> finalList, List<Integer> list) {

        if (0 == target) {
            System.out.println(list);
            finalList.add(new ArrayList<>(list));

            // finalList.add(list);
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target) {
                break;
            }
            list.add(candidates[j]);
            findSum(j, candidates, target - candidates[j], finalList, list);
            list.remove(list.size() - 1);
        }
    }
}

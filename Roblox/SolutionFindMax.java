package Roblox;

import java.util.HashSet;
import java.util.Set;

public class SolutionFindMax {

    private int findMax(int[] arr, int max) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            Set<Integer> temp = new HashSet<>();
            for (int sum : set) {
                int he = i + sum;
                if (he <= max) {
                    temp.add(he);
                }
                if (he > result)
                    result = he;
            }
            set.addAll(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 8, 5, 9 };
        SolutionFindMax sfm = new SolutionFindMax();
        // System.out.println(sfm.findMax(arr, 20));

        String s = "1 + 1";
        int i = 0;
        while (i < s.length()) {
            char t = s.charAt(i);
            if (t == ' ')
                continue;
            if (t == '(')
                continue;
            i++;

        }
    }
}
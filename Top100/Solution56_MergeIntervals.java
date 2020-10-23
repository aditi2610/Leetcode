
package Top100;

import java.util.Arrays;

public class Solution56_MergeIntervals {
    public void merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution56_MergeIntervals merger = new Solution56_MergeIntervals();
        int[][] tre = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
        merger.merge(tre);

    }
}
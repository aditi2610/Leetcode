package Facebook;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<int[]>();

        if (intervals.length == 0)
            return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        result.add(intervals[0]);
        int k = 0;
        int i = 1;
        while (i < intervals.length) {
            int[] temp = result.get(k);
            if (intervals[i][0] <= temp[1]) {
                if (intervals[i][1] > temp[1]) {
                    temp[1] = intervals[i][1];

                }
            } else {
                result.add(intervals[i]);
                k++;
            }
            i++;
        }

        return result.parallelStream().mapToInt(Integer::intValue).toArray();
    }
}

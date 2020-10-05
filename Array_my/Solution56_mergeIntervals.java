package Array_my;

import java.math.BigInteger;

public class Solution56_mergeIntervals{
    public int[][] merge(int[][] intervals) {
        int currentArray = 1;
        while (currentArray < intervals.length) {
            if (intervals[currentArray][0] <= intervals[currentArray - 1][1]) {
                // extend the outer limit
                intervals[currentArray][0] = intervals[currentArray-1][0];
                intervals[currentArray-1][0] = 0;
                intervals[currentArray-1][1] = 0; 
                //intervals[currentArray][] = {0,0};

            }
            currentArray++;
        
        }
        return intervals;

    }

    public static void main(String args[]){
        Solution56_mergeIntervals merge = new Solution56_mergeIntervals();
        int[][] intervals = {{1,3},{2,6},{4,7},{2, 9}, {10,12}, {2,10}};
         merge.merge(intervals);
         System.out.println(intervals);
         long l =1;
         long sd=2;
        
    }
}
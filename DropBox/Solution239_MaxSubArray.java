package DropBox;

import java.util.ArrayList;
import java.util.List;

public class Solution239_MaxSubArray {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // List<Integer> result = new ArrayList<Integer>();
        int result[] = new int[nums.length - k + 1];
        int maxValue = nums[0];
        int maxIndex = 0;
        // int start = 0;
        maxIndex = calculateMax(nums, 0, k);
        int s = 1;
        result[0] = nums[maxIndex];
        maxValue = nums[maxIndex];
        for (int i = k; i < nums.length; i++) {
            if (i - maxIndex < k) {
                if (nums[i] < maxValue)
                    result[s] = nums[maxIndex];
                else {
                    maxValue = nums[i];
                    maxIndex = i;
                    result[s] = maxValue;
                }
            } else {
                maxIndex = calculateMax(nums, i - k + 1, i + 1);
                maxValue = nums[maxIndex];
                result[s] = maxValue;
            }
            s++;
        }
        // System.out.println(nums[maxIndex]);
        // System.out.println(maxIndex);
        return result;
    }

    private int calculateMax(int[] nums, int start, int end) {
        int maxValue = nums[start];
        int maxIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Solution239_MaxSubArray ms = new Solution239_MaxSubArray();
        int[] trsy = { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int[] trsy = { 1 };
        // int[] trsy = { 2, 4, 7 };
        int[] ans = ms.maxSlidingWindow(trsy, 3);
        for (int i : ans) {
            System.out.println(i + " ");
        }
        // System.out.println();
    }
}
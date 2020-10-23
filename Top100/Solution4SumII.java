package Top100;

import java.util.HashMap;

public class Solution4SumII {

    int calculateSum(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                int locSum = -1 * (C[k] + D[l]);
                if (map.containsKey(locSum)) {
                    count += map.get(locSum);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution4SumII fSum = new Solution4SumII();
        int[] A = { 1, 2 };
        int B[] = { -2, -1 };
        int C[] = { -1, 2 };
        int D[] = { 0, 2 };
        System.out.println(fSum.calculateSum(A, B, C, D));
    }
}
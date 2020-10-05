package DynamicProgramming;

public class Solution152_MaxProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums == null)
            return 0;
        int maxProduct = Integer.MIN_VALUE;
        int ansArray[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            ansArray[i][i] = nums[i];
            maxProduct = ansArray[i][i] > maxProduct ? ansArray[i][i] : maxProduct;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ansArray[i][j] = ansArray[i][j - 1] * nums[j];
                maxProduct = ansArray[i][j] > maxProduct ? ansArray[i][j] : maxProduct;
            }
        }

        return maxProduct;
    }

    public static void main(String args[]) {
        Solution152_MaxProductSubArray maxP = new Solution152_MaxProductSubArray();
        int[] arr = { 4, 5, -2, 10, 4, 0 };
        System.out.println(maxP.maxProduct(arr));
    }
}
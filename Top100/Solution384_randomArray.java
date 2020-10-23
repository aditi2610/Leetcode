package Top100;

import java.util.concurrent.ThreadLocalRandom;

public class Solution384_randomArray {
    int[] original;
    int[] shuffled;

    public Solution384_randomArray(int[] nums) {
        original = new int[nums.length];
        createCopy(nums);
        shuffled = nums;
    }

    private void createCopy(int[] nums) {
        // int[] original = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            original[i] = nums[i];
        }
        // return original;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // int[] temp = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            // generate a random number between i and maxLength
            int randomNum = ThreadLocalRandom.current().nextInt(i, original.length);
            // swap numbers at these points
            swapNumbers(i, randomNum);
        }
        return shuffled;

    }

    private void swapNumbers(int i, int randomNum) {
        int temp = shuffled[i];
        shuffled[i] = shuffled[randomNum];
        shuffled[randomNum] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 6, 2, 4 };
        Solution384_randomArray rand = new Solution384_randomArray(arr);

        int[] a = rand.shuffle();
        for (int i : a) {
            System.out.print(i);
        }
        System.out.println();

        a = rand.reset();
        for (int i : a) {
            System.out.print(i);
        }

    }
}

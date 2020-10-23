package Top100;

public class Solution334_IncreasingSeq {

    public boolean increasingTriplet(int[] nums) {

        int A = Integer.MAX_VALUE;
        int B = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < A) {
                A = i;
            } else if (i > A && i < B) {
                B = i;
            } else if (i > B) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution334_IncreasingSeq increasingSeq = new Solution334_IncreasingSeq();
        int[] nums = { 6, 3, 4, 1, 5 };
        if (increasingSeq.increasingTriplet(nums))
            System.out.println("true");
    }
}

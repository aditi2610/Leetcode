package robinhood;

public class Sawtooth {

    public static int getSawtoothCount(int[] nums) {
        int answer = 0;
        int n = nums.length;

        boolean dir;
        int i = 0, j = 1;

        // Outermost loop.
        while (j < n) {
            // We skip all the duplicate elements since they can't contribute to our result.
            while (j < n && nums[j - 1] == nums[j]) {
                j++;
            }

            // If skipping duplicates leads to end of array, we break and return answer.
            if (j == n)
                break;

            i = j - 1;

            // Direction variable. We need this to store whether we go UP or DOWN in current
            // iteration.
            // It is initialized as TRUE if direction for nums[0] -> nums[1] is UP,
            // otherwise it's false.
            dir = nums[j - 1] < nums[j];

            // This while loop condition is the trickiest part imho. If nums[j-1] < nums[j]
            // then we know dir should be true,
            // Otherwise if nums[j-1] > nums[j] then dir is false, hence we use !dir.
            while (j < n && (nums[j - 1] < nums[j] && dir || nums[j - 1] > nums[j] && !dir)) {
                // Extend the window and flip the direction.
                j++;
                dir = !dir;
            }

            System.out.println("j is :" + j);
            // Calculate subarrays count for current window size.
            answer += ((j - i) * (j - i - 1)) / 2;
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] nds = { 1, 2, 1, 2, 1 };
        System.out.println(getSawtoothCount(nds));
    }
}

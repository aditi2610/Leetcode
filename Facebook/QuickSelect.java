package Facebook;

public class QuickSelect {

    int quickSelect(int[] nums, int k) {
        return sort(0, nums.length, nums, k);
    }

    int sort(int startingIndex, int endIndex, int[] nums, int k) {
        int i = startingIndex - 1, j = startingIndex + 0;
        int pivot = nums[endIndex - 1], pivotIndex = endIndex - 1;
        while (i < endIndex && j < endIndex) {
            if (nums[j] < pivot) {
                i++;
                if (i != j)
                    swap(i, j, nums);
            }
            j++;
        }
        i++;
        // putting pivot at its right position.
        nums[pivotIndex] = nums[i];
        nums[i] = pivot;
        // checking if this is the required index.
        if (k == i + 1) {
            return pivot;
        } else if (k < i) {
            return sort(0, i, nums, k);
        } else
            return sort(i, nums.length, nums, k);
    }

    public static void main(String[] args) {
        int[] num = { 1, 3, 2, 4, 8, 5 };
        QuickSelect quick = new QuickSelect();
        System.out.println(quick.quickSelect(num, 2));
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

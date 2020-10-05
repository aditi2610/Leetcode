package RepeatThese;

public class Solution31_nextPermutationII {
    public void nextPermutation(int[] nums) {
        int lastIndex= nums.length-2;
        while(lastIndex >=0 && nums[lastIndex+1]<= nums[lastIndex]){
                lastIndex--;
        }

        if(lastIndex >=0){
            int j = nums.length - 1;
            while (j > lastIndex && nums[j] <= nums[lastIndex])
                j--;
            swap(j, lastIndex, nums);
        }
       
        

        reverse(lastIndex+1, nums.length-1, nums);

    }

    private void swap(int j, int lastIndex, int[] nums) {
        int temp = nums[j];
        nums[j]= nums[lastIndex];
        nums[lastIndex] = temp;
    }

    private void reverse(int start, int end, int[] nums) {
        
        int tempe = 0;
        while (start < end) {
            tempe = nums[start];
            nums[start] = nums[end];
            nums[end] = tempe;
            start++;
            end--;

        }
    }

    public static void main(String args[]){
        Solution31_nextPermutationII nextPerm = new Solution31_nextPermutationII();
        int[] nums = {1,2,5,8,3};
        //int[] nums = {1,2,3};
        //int[] nums = {3,2,1};
        nextPerm.nextPermutation(nums);
        for (int i: nums){
            System.out.print(i + " ");
        }
    }
}
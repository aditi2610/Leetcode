package Array_my;


public class Solution31_NextPermutation{
    public void nextPermutation(int[] nums) {
       int last = nums.length-1;
       int temp=0;
        boolean hasChanged= false;
        while(last >0){
            if(nums[last]> nums[last-1]){
                //swap
                temp = nums[last];
                nums[last] = nums[last-1];
                nums[last-1] = temp;
                last--;
                //hasChanged = true;
                break;
            }
            last--;
      }
    //   if(!hasChanged)
        reverse(last+1, nums.length - 1, nums);
    //   if(original.equals(nums)){
    //       reverse(nums);
    //   } 

    }
    
    private void reverse(int start, int end, int[] nums) {
            //int start = 0; int end = nums.length-1;
            int tempe =0;
            while(start< end){
                tempe = nums[start];
                nums[start] = nums[end];
                nums[end] =tempe;
                start++;
                end--;

            }
    }

    public static void main(String args[]) {

        Solution31_NextPermutation nextPerm = new Solution31_NextPermutation();
        int[] nums = {1,3,2};
        //int[] nums = { 6,5,3,4,2,1 };
        nextPerm.nextPermutation(nums);
        for(int i : nums){
            System.out.print(i);
        }


    }
}
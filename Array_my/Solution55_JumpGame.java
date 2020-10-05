package Array_my;

public class Solution55_JumpGame {
    public boolean canJump(int[] nums) {
        int i = 0;
        if(nums.length == 1)
            return true;
      
        while (i < nums.length) {
           int k=i-1;
            if (nums[i] == 0) {
                int r =1;
                for (k = i - 1; k >= 0; k--, r++) {
                    if (nums[k] > r || nums[k]+k == nums.length-1)
                      {
                         break;
                      } 

                }
                if( k  < 0)
                    return false;
              
            }
            i++;
        }
        return true;

    }

    public static void main(String args[]){
        Solution55_JumpGame jumpGame = new Solution55_JumpGame();
        //int[] nums = {2,0,0};
        //{4,1,0,2,0,0} i =4  k = 3
        int[] nums= {2,3,1,0,1,4};
        if(jumpGame.canJump(nums))
            System.out.println("True");
            else 
            System.out.println("False");
    }
}
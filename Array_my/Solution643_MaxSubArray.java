package Array_my;

public class Solution643_MaxSubArray {
    
    public double findMaxAverage(int[] nums, int k) {
  
    double maxAvg = Integer.MIN_VALUE;
       double avg =0;
       
        for(int i=0; i<=nums.length -k; i++){
            int t = 0;
            avg =0;
            while(t<k && i+t < nums.length){
                avg += nums[i+t];
                t++;
            }
            avg  = avg/k;
            if(avg > maxAvg)
                maxAvg   = avg;
        }

        return maxAvg;
    }

    public static void main(String args[]){
        Solution643_MaxSubArray maxSubArray = new Solution643_MaxSubArray();
        // int[] nums = {1,12,-5,-6,50,3 };
        // System.out.println(maxSubArray.findMaxAverage(nums, 4));
        // int[] nums1 = {5};
        // System.out.println(maxSubArray.findMaxAverage(nums1, 1));
        int[] nums1 = {1,12,-5,-6,50,3};
        System.out.println(maxSubArray.findMaxAverage(nums1, 4));


        
    }
}
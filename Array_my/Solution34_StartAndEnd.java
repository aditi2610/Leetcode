package Array_my;


public class Solution34_StartAndEnd {
    
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0]= findLeftMostIndex(nums, target); 
        result[1]= findRightMostIndex(nums, target);
        return result;
    }


    private int findRightMostIndex(int[] nums, int target) {
        int index =-1;
        int start = 0, mid = 0;
        int end = nums.length - 1;
        while(start <= end){
            mid = start + (end-start)/2;
            if(nums[mid]> target)
                end = mid-1;
            else if(nums[mid]< target)
                start = mid+1;
            else if(nums[mid]==target){
                index = mid;
                start = mid+1;
            }
        }
        return index;
    }

    private int findLeftMostIndex(int[] nums, int target) {
        int index =-1;
        int start = 0, mid =0; 
        int end = nums.length-1;
        while(start<= end){
            mid = start+ (end-start)/2 ;
            if(nums[mid] > target)
                end = mid-1;
            else if(nums[mid]< target)
                start= mid+1;
            else if(nums[mid]== target){
                index = mid;
                end = mid-1;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        //int[] nums ={5,7,7,8,8,10};
        int[] nums = {8};
        Solution34_StartAndEnd startEnd = new Solution34_StartAndEnd();
        int[] result = startEnd.searchRange(nums, 8);
        for(int i: result){
            System.out.print(i + " ");
        }
    }
}
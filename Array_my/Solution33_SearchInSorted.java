package Array_my;

public class Solution33_SearchInSorted {
    // 4,5,6,7,0,1,2
    public int search(int[] nums, int target) {
        return find(0, nums.length-1, nums, target);
    }

    private int find(int start, int end, int[] nums, int target){
        int index =-1;
        int mid =0;
        while(start<= end){
            mid = start + (end- start)/2;
        //    if(nums[mid] > target){
        //        if(nums[start] > nums[mid])
        //             start = mid+1;
        //        else if(nums[end] > nums[mid])
        //         {
        //             end = mid-1;
        //         }else
        //             start = mid+1;

        //    }
        //    else if(nums[mid] < target){
        //        if(nums[start] > target || nums[end]< nums[mid] || nums[end] <= target)
        //             start = mid+1;
        //     //    else if()
        //     //         start = mid+1; 
        //         else if(nums[end] < target)
        //             end = mid-1;
               
                
        //    }
        //    else 
        //     return mid;

        if(nums[mid]> target){
            if(nums[start] >= target && nums[end] > nums[mid])
                end = mid-1;
           
            // else if(nums[end] <= nums[mid]){
            //     start = mid+1;
            else{
                start = mid + 1;
            }
        } else if(nums[mid] < target){
            if(nums[end] < nums[mid])
                start = mid+1;
            else if(nums[end] >= target)
                start= mid+1;
            else 
                end = mid-1;
                
        }else 
            return mid;


        }

        return index;
    }
    public static void main(String args[]){
        Solution33_SearchInSorted search = new Solution33_SearchInSorted();
        // int[] nums= {4,5,6,7,8,1,2,3};
        //  //int [] nums = {5,1,2,3,4};
        //  System.out.println(search.search(nums, 1));
       
        
       //int[] nums = { 4, 5, 6, 7,0, 1, 2 };
        //System.out.println(search.search(nums, 0));
        // int[] nums = {1,3};
        // // int[] nums = {5,1,3};
        //  System.out.println(search.search(nums, 3));
       //System.out.println( search.search(nums, 8));

    //    int[] fin ={1,3,5};
    //    System.out.println(search.search(fin, 2));
     int[] fin1 ={3,5,1};
     System.out.println(search.search(fin1, 3));
    }
}
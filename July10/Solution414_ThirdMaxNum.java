package July10;

public class Solution414_ThirdMaxNum {


    public int thirdMax(int[] nums) {
    Integer thirdMax = null; 
    Integer secondMax = null;
    int max = nums[0];
    for(int i=1; i< nums.length; i++){
        int n= nums[i];
        if(max == n || 
         secondMax != null && secondMax == n || 
        thirdMax != null && thirdMax == n)
            continue;
        if(n > max){
            thirdMax = secondMax;
            secondMax = max;
            max = n;
        }else if(secondMax == null || (n < max && n > secondMax) ){
            thirdMax = secondMax;
            secondMax = n;
        }else if(thirdMax == null || (n < secondMax && n > thirdMax)){
            thirdMax = n;
        }
    }

    if(thirdMax == null)
    return max;
    return thirdMax;

    }

    public static void main(String arfs[]){
        Solution414_ThirdMaxNum thirdMax = new Solution414_ThirdMaxNum() ;
        int[] nums = {2, 1, 1};
        System.out.println(thirdMax.thirdMax(nums));
    }
}
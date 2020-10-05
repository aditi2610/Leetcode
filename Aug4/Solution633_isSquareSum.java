package Aug4;

public class Solution633_isSquareSum {
    public boolean judgeSquareSum(int c) {
       int root = (int)Math.sqrt(c);
       for(int k =root; k>=0; k--){
           int square = k*k;
           if(square == c)
            return true;
            int diff = c - square;
            if(Math.sqrt(diff) %1 ==0)
                return true;
       }
       return false;
    }

    public static void main(String args[]){
        Solution633_isSquareSum sqSum = new Solution633_isSquareSum();
        if (sqSum.judgeSquareSum(5))
            System.out.println("Its a square Sum");
        else
            System.out.println("Oops");

    }
}
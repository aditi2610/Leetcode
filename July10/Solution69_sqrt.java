class Solution69_sqrt{
    public static void main(String[] args){
        System.out.println("Hello Aditi ");
        Solution69_sqrt sol = new Solution69_sqrt();
        System.out.println("Answer is: " +sol.calculateSquareRoot(6));
    }

    private int calculateSquareRoot(int x){
        if(x<2)
        return x;
        int left, right, pivot;
        int num = 0;
        left = 2; 
        right  = x/2;
        while (left <= right){
            pivot = left + (right - left) / 2;
           num = pivot* pivot;
           if(num > x){
               right = pivot-1;
           }
           else if(num < x)
           {
               left = pivot +1;
           }
           else
           return pivot;
        }
        return right;
    }
}
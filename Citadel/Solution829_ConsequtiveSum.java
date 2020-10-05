package Citadel;

public class Solution829_ConsequtiveSum {

    int findConsequtiveSum(int N) {

        /**
         * with n consequtive number , the first number/sum we can form is: 1+2+3 +...
         * +n ; the next number that we can form is 2 + 3 + 4 + 5 +....+ n + n+1; ~
         * 1+2+3+4+ n+n = N now if i do N - n*(n+1)/2 this number should still be
         * divisible by n (if it has consequtive sums)
         * 
         */
        int result = 0;
        for (int i = 2; i * (i + 1) / 2 <= N; i++) {
            int n = N - (i * (i + 1)) / 2;
            if (n % i == 0) {
                System.out.println("i is: " + i);
                result++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution829_ConsequtiveSum con = new Solution829_ConsequtiveSum();
        System.out.println(con.findConsequtiveSum(9));
    }
}

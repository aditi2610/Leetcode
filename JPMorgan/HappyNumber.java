package JPMorgan;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    boolean findHappyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int rem = n % 10;
                sum += rem * rem;
                n = n / 10;
            }
            if (sum == 1)
                return true;
            else
                n = sum;
            System.out.println("new NUmber is: " + sum);

        }
        return false;
    }

    public static void main(String[] args) {
        HappyNumber hm = new HappyNumber();
        System.out.println(hm.findHappyNumber(12));
    }
}

package RepeatThese;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindMaximumsInKSubArray {

    int[] findMaximumInAWindowOfSizeK(int[] m, int k) {

        // 0 1 2 3 4 5
        // 4 10 5 -1 3 6 k=3
        int[] result = new int[m.length - k + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && m[i] > m[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        result[0] = m[deque.peekFirst()];

        for (int i = k; i < m.length; i++) {
            if (i - deque.peekFirst() >= k)
                deque.pollFirst();

            while (deque.size() > 0 && m[deque.peekLast()] <= m[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            result[i - k + 1] = m[deque.peekFirst()];
            // if i- peekFirst < k {its a valid window}
            // if deque.peekLast is greater than a[i]
            // add a[i] to the queue
            // while(deque.peekLast < a[i])
            // pop dfrom last
            // add a[i]

        }
        return result;
    }

    public static int max_image_size(int x, List<Integer> db) {
        // create a deque of size x
        // for int(i: x)
        // add the element to the deque if it is less than the previously added number

        // add the index of the number
        // for intx: to db.length-x
        // if the number is less than the previously added number, and
        System.out.println("x is: " + x);
        for (int j = 0; j < db.size(); j++) {
            System.out.println(db.get(j));
        }
        int max = 0;
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.add(0);
        for (int i = 1; i < x; i++) {
            if (db.get(deque.peekLast()) < db.get(i))
                deque.addLast(i);
            else {
                deque.pollFirst();
                deque.addFirst(i);
            }

        }
        max = db.get(deque.peekFirst());
        System.out.println("max after 1st iteration is :  " + max);
        for (int i = x; i < db.size(); i++) {
            // if the element is out of range
            if (i - deque.peekFirst() >= x) {
                System.out.println("popping it out as its out of index " + deque.peekFirst());
                deque.pollFirst();
            }

            while (!deque.isEmpty() && db.get(deque.peekLast()) > db.get(i)) {
                System.out.println("Popping this out becuase it is less than new number " + deque.peekLast());
                deque.pollLast();
            }
            deque.addLast(i);
            System.out.println("Max out of " + i + "iteration is: " + db.get(deque.peekFirst()));
            if (max < db.get(deque.peekFirst())) {
                max = db.get(deque.peekFirst());
                System.out.println("max i: " + max);
            }

            System.out.println(deque.toString());

        }

        return max;
    }

    public static void main(String[] args) {
        FindMaximumsInKSubArray find = new FindMaximumsInKSubArray();
        int[] arre = { 4, 10, 5, -1, 3, 6 };
        int[] re = find.findMaximumInAWindowOfSizeK(arre, 3);
        for (int i : re)
            System.out.println(i);
    }
}

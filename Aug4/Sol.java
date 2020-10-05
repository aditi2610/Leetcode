package Aug4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Sol {

    public static int max_image_size(int x, List<Integer> db) {
        // create a deque of size x
        // for int(i: x)
        // add the element to the deque if it is less than the previously added number

        // add the index of the number
        // for intx: to db.length-x
        // if the number is less than the previously added number, and

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
        List<Integer> list = new ArrayList<>();
        // list.add(5);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(8);
        Sol s = new Sol();
        System.out.println(" Max : " + s.max_image_size(3, list));
    }
}

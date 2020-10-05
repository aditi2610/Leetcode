package robinhood;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimalList {

    public static void main(String[] args) {
        MinimalList mi = new MinimalList();
        int n[] = { 2, 7, 8, 5, 1, 6, 3, 9, 4 };
        List<Integer> list = mi.minimalList(n);
        System.out.println("     ");
        for (int a : list) {
            System.out.println(a);
        }
        // List list = new LinkedList<Integer>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.remove(2);
        // list.add(4);
        // System.out.println(list.get(2));
        // System.out.println(list.toString());
    }

    List minimalList(int[] ar) {
        List result = new ArrayList<Integer>();
        List list = new LinkedList<Integer>();

        for (int i : ar) {
            list.add(i);
        }

        while (list.size() > 1) {
            int min = 0;
            int minimumValue = Integer.MAX_VALUE;
            for (int k = 0; k < list.size(); k++) {
                int current = (int) list.get(k);
                int before = k == 0 ? 0 : (int) list.get(k - 1);
                int after = k == list.size() - 1 ? 0 : (int) list.get(k + 1);
                if (current > before && current > after) {
                    if (minimumValue > current) {
                        // System.out.println("min is: " + min);
                        min = k;
                        minimumValue = (int) list.get(min);
                    }

                }

            }
            result.add((int) list.get(min));
            // System.out.println((int) list.get(min));
            list.remove(min);
        }
        result.add((int) list.get(0));
        // while linkedList .size >0
        // min =0;
        // for int k =0; k< linkedlist.size ; k++
        // if k == 0 and k> k+1
        // if k == last element and k> k-1
        // min = k
        // if(k > k-1) && k > k+1
        // if(min < k )
        // update min index
        // add min to result
        // pop min out of linkedList

        return result;

    }
}

package Facebook;

import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        MergeKSortedArrays merge = new MergeKSortedArrays();
        int[] array1 = { 1, 4, 5 };
        int[] array2 = { 1, 3, 4 };
        int[] array3 = { 2, 5, 9 };
        int[] sns = merge.sort(array1, array2, array3);
        for (int i : sns)
            System.out.println(i);
    }

    int[] sort(int[] arr1, int[] arr2, int arr3[]) {
        char[] a = {};

        int[] result = new int[arr1.length + arr2.length + arr3.length];
        int k = 0;
        PriorityQueue<Temp> queue = new PriorityQueue<Temp>(3, (a, b) -> a.val - b.val);
        if (arr1.length > 0)
            queue.add(new Temp(1, arr1[0], 0));
        if (arr2.length > 0)
            queue.add(new Temp(2, arr2[0], 0));
        if (arr3.length > 0)
            queue.add(new Temp(3, arr3[0], 0));
        while (queue.size() > 0) {
            Temp t = queue.poll();

            System.out.println(t.seq + " " + t.val);
            if (k == 0 || result[k - 1] != t.val)
                result[k++] = t.val;
            if (t.seq == 1 && t.index < arr1.length - 1) {
                queue.add(new Temp(1, arr1[t.index + 1], t.index + 1));
            } else if (t.seq == 2 && t.index < arr2.length - 1) {
                queue.add(new Temp(2, arr2[t.index + 1], t.index + 1));
            } else if (t.seq == 3 && t.index < arr3.length - 1) {
                queue.add(new Temp(3, arr3[t.index + 1], t.index + 1));
            }
        }
        return result;

    }

    class Temp {
        int seq;
        int val;
        int index;

        Temp(int s, int v, int i) {

            seq = s;
            val = v;
            index = i;
        }
    }
}

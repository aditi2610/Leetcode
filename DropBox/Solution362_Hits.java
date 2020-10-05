package DropBox;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution362_Hits {
    Queue<Integer> queue;
    int count;

    public Solution362_Hits() {
        queue = new LinkedList<Integer>();
        count = 0;
    }

    /**
     * Record a hit.
     * 
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        queue.add(timestamp);
        count++;
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * 
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        // int head = queue.peek();
        // while (queue.size() > 0 && timestamp - head >= 300) {
        // queue.remove();
        // count--;
        // if (!queue.isEmpty())
        // head = queue.peek();
        // }

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            int head = iterator.next();
            if (timestamp - head > 299) {
                iterator.remove();
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution362_Hits hits = new Solution362_Hits();
        System.out.println(hits.getHits(4));
        hits.hit(1);
        hits.hit(2);
        System.out.println(hits.getHits(4));
        hits.hit(6);
        System.out.println(hits.getHits(301));

        System.out.println(hits.getHits(307));

    }
}
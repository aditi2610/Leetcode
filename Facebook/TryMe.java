package Facebook;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class TryMe {
    public static void main(String[] args) {

        // System.out.println("prachi".compareTo("aditi"));

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 2);
        map.put("b", 4);
        map.put("c", 3);
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (a, b) -> b.getValue() < a.getValue() ? 1 : -1);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}

class Comp implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() == e2.getValue()) {
            return e1.getKey().compareTo(e2.getKey());
        } else {
            return e1.getValue() > e2.getValue() ? 1 : -1;
        }
    }

}
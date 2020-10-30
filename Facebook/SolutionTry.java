package Facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionTry {

    int arrival;
    int departure;

    SolutionTry(int arrival, int departure) {
        this.arrival = arrival;
        this.departure = departure;
    }

    @Override
    public String toString() {
        return arrival + " " + departure;
        // return super.toString();
    }

    public static void main(String[] args) {
        List<SolutionTry> list = new ArrayList<SolutionTry>();
        list.add(new SolutionTry(5, 3));
        list.add(new SolutionTry(1, 3));
        list.add(new SolutionTry(1, 2));

        list.add(new SolutionTry(3, 2));
        list.add(new SolutionTry(3, 1));
        list.add(new SolutionTry(3, 3));

        Collections.sort(list,
                (a, b) -> (a.arrival - b.arrival) == 0 ? a.departure - b.departure : a.arrival - b.arrival);

        System.out.println(list.toString());

    }
}

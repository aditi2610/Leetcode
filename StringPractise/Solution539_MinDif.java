package StringPractise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution539_MinDif {

    public int findMinDifference(List<String> timePoints) {
        int minutes = 0;
        Iterator<String> iterator = timePoints.iterator();
        int i = 0;
        int arr[] = new int[4];
        while (iterator.hasNext()) {
            String temp = iterator.next();
            arr[i++] = Integer.parseInt(temp.split(":")[0]);
            arr[i++] = Integer.parseInt(temp.split(":")[1]);
        }
        if (arr[0] < 12)
            arr[0] = 24 + arr[0];
        if (arr[2] < 12)
            arr[2] = 24 + arr[2];

        if (arr[0] >= arr[2]) {
            if (arr[1] > arr[3]) {
                minutes = arr[1] - arr[3] + 60 * (arr[0] - arr[2]);
            } else
            // if (arr[1] < arr[3])
            {
                minutes = 60 - arr[1] - arr[3] + 60 * (arr[0] - 1 - arr[2]);
            }

        } else {
            if (arr[1] > arr[3]) {
                minutes = 60 + arr[3] - arr[1] + 60 * (arr[2] - 1 - arr[0]);
            } else {
                minutes = arr[3] - arr[0] + 60 * (arr[2] - arr[0]);
            }
        }
        return minutes;
    }

    public static void main(String args[]) {

        Solution539_MinDif minDif = new Solution539_MinDif();
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("7:58");
        System.out.println(minDif.findMinDifference(list));

    }
}

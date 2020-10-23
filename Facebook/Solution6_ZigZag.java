package Facebook;

import java.util.ArrayList;
import java.util.List;

public class Solution6_ZigZag {
    public String convert(String s, int numRows) {
        // create list = numRows.
        // for int i =0; i< s.length; i++
        // list.get i% numRows

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0;
        int count = 0;
        boolean goDown = true;
        while (i < s.length()) {
            char c = s.charAt(i);
            list.get(count).append(c);
            if (goDown) {
                if (count == numRows - 1) {
                    goDown = false;
                    count--;
                } else {
                    count++;
                }
            } else {
                if (count == 0) {
                    goDown = true;
                    count++;
                } else {
                    count--;
                }
            }
            i++;

        }
        StringBuilder bld = new StringBuilder();
        for (StringBuilder str : list) {
            System.out.println(str);
            bld.append(str);
        }
        return bld.toString();
    }

    public static void main(String[] args) {
        Solution6_ZigZag zig = new Solution6_ZigZag();
        System.out.println(zig.convert("PaypalIshiring", 3));
    }
}

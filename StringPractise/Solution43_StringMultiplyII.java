package StringPractise;

import java.util.ArrayList;
import java.util.List;

public class Solution43_StringMultiplyII {
    public String multiply(String num1, String num2) {
        if(num1 == null ||num2 == null || num1.length() ==0  || num2.length() ==0)
            return "0";
        List<Integer> list = new ArrayList<>();
        int indexOfNum2 = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            int prevValue = 0;
            int indexOfNum1 =0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                if (list.size() > indexOfNum1+  indexOfNum2) {
                    prevValue = list.get(indexOfNum2 + indexOfNum1);
                }
                int product = prevValue + (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + carry;
                if (list.size() > indexOfNum2+ indexOfNum1)
                    list.set(indexOfNum2+ indexOfNum1, product % 10);
                else
                    list.add(product % 10);
                carry = product / 10;
                indexOfNum1++;
                prevValue =0;
            }
            indexOfNum2++;
            if(carry !=0)
                list.add(carry);
            System.out.println(list.toString());

        }

        StringBuilder str = new StringBuilder();
        for(int i : list){
            str.append(i);
        }

        return str.reverse().toString();

    }

    public static void main(String args[]) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        //System.out.println(l.toString());
        //l.set(0, 1);
        // System.out.println( " sff " + l.get(0));
        Solution43_StringMultiplyII to = new Solution43_StringMultiplyII();
         System.out.println(to.multiply("123", "456"));
    }
}
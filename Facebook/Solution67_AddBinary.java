package Facebook;

public class Solution67_AddBinary {

    public String addBinary(String str1, String str2) {
        // 11 1
        StringBuilder strBuilder = new StringBuilder();
        if (str1 == null || str1.length() == 0) {
            return str2;
        }
        if (str2 == null || str2.length() == 0)
            return str1;
        int carry = 0;
        int sum = 0;
        for (int i = str1.length() - 1, j = str2.length() - 1; i >= 0 || j >= 0; i--, j--) {

            int m = i >= 0 ? str1.charAt(i) - '0' : 0;
            int n = j >= 0 ? str2.charAt(j) - '0' : 0;
            sum = carry + m + n;
            switch (sum) {
                case 1:
                    carry = 0;
                    strBuilder.append("1");
                    break;
                case 0:
                    carry = 0;
                    strBuilder.append("0");
                    break;
                case 2:
                    carry = 1;
                    strBuilder.append("0");
                    break;

                case 3:
                    carry = 1;
                    strBuilder.append("1");
                    break;
            }
            System.out.println(strBuilder + " carry = " + carry);
        }
        if (carry > 0) {
            strBuilder.append(carry);
        }
        return strBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution67_AddBinary add = new Solution67_AddBinary();
        System.out.println(add.addBinary("11", "1"));
    }
}

package StringPractise;

public class Solution537_ComplexNumber {
    public String complexNumberMultiply(String a, String b) {
        int var1 = getRealNumber(a);
        int var2 = getRealNumber(b);
        int var1i = getImaginaryNumber(a);
        int var2i = getImaginaryNumber(b);

        int result = var1 * var2 + (var1i * var2i * -1);
        int resulti = var1i * var2 + var2i * var1;
        return result + "+" + resulti + "i";
    }

    private int getImaginaryNumber(String a) {
        int num = 0;
        int negative = 1;
        boolean flag = false;
        int i = a.length() - 1;
        int count = 0;
        while (i >= 0) {
            char c = a.charAt(i);
            if (c == 'i') {
                flag = true;
                num = 0;
                i--;
                continue;
            }
            if (c == '+')
                break;
            if (c == '-') {
                negative = -1;
                break;
            }

            if (flag) {
                int temp = 1;
                for (int k = 0; k < count; k++)
                    temp *= 10;
                num = (c - '0') * temp + num;
                count++;

            }
            i--;
        }

        if (flag && num == 0)
            return 0;
        return num * negative;
    }

    // the only thing is.. it has to be a+bi and not bi+a
    private int getRealNumber(String a) {
        int num = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '+')
                break;
            if (c == 'i')
                return 0;
            num = num * 10 + (c - '0');
        }
        return num;
    }

    public static void main(String[] args) {
        Solution537_ComplexNumber complex = new Solution537_ComplexNumber();
        System.out.println(complex.complexNumberMultiply("78+-76i", "-86+72i"));
    }
}
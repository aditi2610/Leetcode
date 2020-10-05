package StringPractise;

public class Solution468_ValidIPII {

    public String validIPAddress(String IP) {
        String result = "neither";
        if (IP.contains("."))
            result = validIPV4(IP);
        else if (IP.contains(":"))
            result = validIPV6(IP);

        return result.trim().length() > 0 ? result : "Neither";
    }

    private String validIPV6(String str) {
        int i = 0;
        int countColon = 0;
        StringBuilder num = new StringBuilder();
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == ':') {
                if (num.length() > 0 && i != str.length() - 1) {
                    num = new StringBuilder();
                    countColon++;
                    i++;
                    continue;
                } else
                    break;
            }
            if (c >= '0' && c <= '9' || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {
                num.append(c);
            } else
                break;
            if (num.length() > 4)
                break;
            i++;

        }

        if (i == str.length() && countColon == 7)
            return "IPv6";

        return " ";
    }

    private String validIPV4(String str) {
        int count = 0;
        int i = 0;
        int num = -1;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                if (num == 0)
                    break;
                if (num == -1)
                    num = 0;
                num = num * 10 + (c - '0');
            }
            if (num > 255)
                break;
            if (c == '.') {
                if (num != -1 && i != str.length() - 1) {
                    num = -1;
                    count++;
                    i++;
                    continue;
                } else
                    break;

            }
            if (c < '0' || c > '9')
                break;

            i++;
        }

        if (i == str.length() && count == 3)
            return "IPv4";
        return " ";
    }

    public static void main(String[] args) {
        Solution468_ValidIPII valid = new Solution468_ValidIPII();
        System.out.println(valid.validIPAddress("256.256.256.256"));
        System.out.println(valid.validIPAddress("172.16.204.1"));
        System.out.println(valid.validIPAddress("172.06.254.1"));
        System.out.println(valid.validIPAddress("1.16..254"));
        // System.out.println(valid.validIPAddress("3:1:a:f:1244:erwt:3:6"));
        // System.out.println(valid.validIPAddress("a:f:3:34544:2:a:1:3")); // more tha
        // // 4 digist
        // System.out.println(valid.validIPAddress("a:1:1:1:1:a:1:1:")); // ends with :
        // System.out.println(valid.validIPAddress("a::f:3:34544:2:a:1:3")); // two
        // colon in between
        // System.out.println(valid.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
        // // more than
        // a

    }
}
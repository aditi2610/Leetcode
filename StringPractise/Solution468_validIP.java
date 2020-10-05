package StringPractise;

public class Solution468_validIP {
    public String validIPAddress(String IP) {
        String[] splitArr = IP.split("\\.");
        String result = " ";
        if (splitArr.length == 1) {
            splitArr = IP.split("\\:");
            result = validateIPV6(splitArr);
        } else {
            result = validateIPV4(splitArr);
        }
        return result.trim().length() > 0 ? result : "neither";
    }

    private String validateIPV6(String[] splitArr) {
        if (splitArr.length != 8)
            return " ";
        for (String str : splitArr) {
            if (str.length() < 1 || str.length() > 4)
                return " ";
            if (null == str || str.length() == 0)
                return " ";
            char[] arr = str.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= '0' && arr[i] <= '9')
                    continue;
                if (arr[i] >= 'a' && arr[i] <= 'f')
                    continue;
                if (arr[i] >= 'A' && arr[i] <= 'F')
                    continue;
                else
                    return " ";
            }
        }

        return "IPV6";
    }

    private String validateIPV4(String[] splitArr) {
        if (splitArr.length != 4)
            return " ";
        for (String str : splitArr) {
            int num = 0;
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > '0' && arr[i] < '9')
                    num = num * 10 + (arr[i] - '0');
                if (num > 255)
                    return " ";
                if (arr[i] < '0' || arr[i] > '9')
                    return " ";
                if (i > 0 && arr[i - 1] == '0')
                    return " ";

            }
            // if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255)
            // return " ";
            // if (str.charAt(0) == '0' && str.length() > 1)
            // return " ";
        }
        return "IPV4";
    }

    public static void main(String args[]) {
        Solution468_validIP validIp = new Solution468_validIP();
        System.out.println(validIp.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(validIp.validIPAddress("172.16.254.1"));
        System.out.println(validIp.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIp.validIPAddress("256.256.256.256"));

        System.out.println(validIp.validIPAddress("1e1.4.5.6"));
        // System.out.println(validIp.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));

    }
}
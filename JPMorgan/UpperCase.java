package JPMorgan;

public class UpperCase {
    String convertToUpperCase(String str) {
        StringBuilder strBuilder = new StringBuilder();
        String[] s = str.split("\\s");
        for (String word : s) {
            strBuilder.append(Character.toUpperCase(word.charAt(0)));

            for (int i = 1; i < word.length(); i++) {
                strBuilder.append(Character.toLowerCase(word.charAt(i)));
            }

            strBuilder.append(" ");
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        UpperCase uc = new UpperCase();
        System.out.println(uc.convertToUpperCase("i am newver FiNEERdsfdf"));

    }
}

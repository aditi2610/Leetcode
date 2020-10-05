package DataBricks;

public class Reverse {

    int countRev(int[] arr) {
        int count = 0;
        // brute force is
        /**
         * for ar create an array revArray[] of reverse iterate over the first array and
         * each element of revArray and increase count on match
         */
        int[] revArr = reverseArray(arr);
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (arr[i] + revArr[j] == arr[j] + revArr[i])
                    count++;
            }
        }

        return count;
    }

    private int[] reverseArray(int[] arr) {
        int[] revArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            revArray[i] = calculateReverse(arr[i]);
            System.out.print(revArray[i] + " ");
        }
        return revArray;
    }

    private int calculateReverse(int arr) {
        int temp = 0;
        while (arr / 10 > 0) {
            temp = temp * 10 + (arr % 10);
            arr = arr / 10;
        }
        temp = temp * 10 + arr;
        return temp;
    }

    public static void main(String[] args) {
        Reverse rev = new Reverse();
        int[] ar = { 1, 20 };
        System.out.println(rev.countRev(ar));
    }
}

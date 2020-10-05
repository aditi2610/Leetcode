package DynamicProgramming;

public class Solution62_UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] array = new int[m][n];
        // Arrays.fill(array, 0);
        return getValue(array, m - 1, n - 1);

    }

    private int getValue(int[][] array, int m, int n) {

        if (m == 0 || n == 0)
            return 1;
        if (array[m - 1][n] == 0)
            array[m - 1][n] = getValue(array, m - 1, n);
        if (array[m][n - 1] == 0)
            array[m][n - 1] = getValue(array, m, n - 1);

        array[m][n] = array[m - 1][n] + array[m][n - 1];

        return array[m][n];
    }

    public static void main(String[] args) {
        Solution62_UniquePath uniqPath = new Solution62_UniquePath();
        System.out.println(uniqPath.uniquePaths(51, 9));

    }
}
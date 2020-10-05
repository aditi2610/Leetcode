package DynamicProgramming;

public class Solution63_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // n o of rows
        int n = obstacleGrid[0].length;
        int[][] arr = new int[m][n];
        return getValue(arr, obstacleGrid, m - 1, n - 1);
        // return 0;

    }

    private int getValue(int[][] arr, int[][] obstacleGrid, int i, int j) {
        int left = 0, top = 0;
        if (obstacleGrid[i][j] == 1)
            return 0;
        if (i == 0 && j == 0)
            return 1;

        if (i > 0) {
            if (obstacleGrid[i - 1][j] == 0 && arr[i - 1][j] == 0)
                arr[i - 1][j] = getValue(arr, obstacleGrid, i - 1, j);
            top = arr[i - 1][j];
        }
        if (j > 0) {
            if (obstacleGrid[i][j - 1] == 0 && arr[i][j - 1] == 0)
                arr[i][j - 1] = getValue(arr, obstacleGrid, i, j - 1);
            left = arr[i][j - 1];
        }

        arr[i][j] = left + top;

        return arr[i][j];

    }

    /*
     * private int getValue(int[][] arr, int[][] obs, int m, int n) { if (obs[m][n]
     * == 1) return 0; if (m == 0 && n == 0) return 1; if (arr[m - 1][n] == 0)
     * getValue(arr, obs, m - 1, n); if (arr[m][n - 1] == 0) getValue(arr, obs, m, n
     * - 1); arr[m][n] = arr[m][n - 1] + arr[m - 1][n]; return arr[m][n]; }
     */
    public static void main(String args[]) {
        Solution63_UniquePathsII un = new Solution63_UniquePathsII();
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        // int[][] obstacleGrid = { { 1 } };
        System.out.println(un.uniquePathsWithObstacles(obstacleGrid));
    }
}
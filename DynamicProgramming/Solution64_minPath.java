package DynamicProgramming;

public class Solution64_minPath {
    public int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;

        int row = grid.length;
        int column = grid[0].length;
        for (int j = 1; j < column; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }

        return grid[row - 1][column - 1];
    }

    public static void main(String args[]) {
        Solution64_minPath minPath = new Solution64_minPath();
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPath.minPathSum(grid));
    }
}
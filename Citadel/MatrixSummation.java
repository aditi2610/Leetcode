package Citadel;

public class MatrixSummation {
    public static void main(String[] args) {
        MatrixSummation sum = new MatrixSummation();
        int[][] an = { { 2, 5, 10 }, { 7, 17, 28 } };
        int[][] re = sum.solveMatrix(an);

    }

    int[][] solveMatrix(int[][] arr) {

        int col = arr[0].length;
        int row = arr.length;
        int[][] result = new int[row][col];
        result[0][0] = arr[0][0];
        for (int i = 1; i < col; i++) {
            result[0][i] = arr[0][i] - arr[0][i - 1];
        }

        for (int j = 1; j < row; j++) {
            result[j][0] = arr[j][0] - arr[j - 1][0];
        }
        // arr[0].length =3 ; arr.length = 2
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int sum = 0;
                for (int a = i; a >= 0; a--) {
                    for (int b = j; b >= 0; b--)
                        sum += result[a][b];
                }
                result[i][j] = arr[i][j] - sum;

            }
        }

        return result;
    }
}

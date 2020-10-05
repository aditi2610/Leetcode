package DropBox;

class Solution289_gameOfLife {
    public void gameOfLife(int[][] board) {
        int row = board.length + 2;
        int column = board[0].length + 2;
        int[][] original = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                original[i][j] = (i == 0 || j == 0) || (i == row - 1 || j == column - 1) ? 0 : board[i - 1][j - 1];
            }
        }

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < column - 1; j++) {
                int count = 0;
                if (original[i][j + 1] == 1)
                    count++;
                if (original[i][j - 1] == 1)
                    count++;
                if (original[i + 1][j] == 1)
                    count++;
                if (original[i - 1][j] == 1)
                    count++;
                if (original[i + 1][j + 1] == 1)
                    count++;
                if (original[i - 1][j + 1] == 1)
                    count++;
                if (original[i - 1][j - 1] == 1)
                    count++;
                if (original[i + 1][j - 1] == 1)
                    count++;
                // Rule1 & 3
                if (original[i][j] == 1 && (count < 2 || count > 3))
                    board[i - 1][j - 1] = 0;
                // Rule 3
                // if (original[i][j] == 1 && count > 3)
                // board[i][j] = 0;
                // not sure if this is really required
                // if(original[i][j] ==1 && (count ==2 || count ==3))
                // board
                // Rule 2
                else if (count == 3 && original[i][j] == 0)
                    board[i - 1][j - 1] = 1;

            }
        }

    }

    public static void main(String args[]) {
        Solution289_gameOfLife gameOfLife = new Solution289_gameOfLife();
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        gameOfLife.gameOfLife(board);
    }
}
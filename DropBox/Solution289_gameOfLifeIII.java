package DropBox;

public class Solution289_gameOfLifeIII {

    public void gameOfLife(int[][] board) {
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = calculateCounts(directions, i, j, board);
                /**
                 * 0 -> 0 =0, 1 ->1 = 1, 0 -> 1 = 3, 1-> 0 =4
                 */

                if (board[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = 4;
                else if (board[i][j] == 0 && count == 3)
                    board[i][j] = 3;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 1;
                else if (board[i][j] == 4)
                    board[i][j] = 0;
            }
        }
    }

    private int calculateCounts(int[][] directions, int row, int column, int[][] ori) {
        int count = 0;
        for (int[] direction : directions) {
            int i = direction[0] + row;
            int j = direction[1] + column;
            if (i >= 0 && i < ori.length && j >= 0 && j < ori[0].length) {
                if (ori[i][j] == 1 || ori[i][j] == 4)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Solution289_gameOfLifeIII two = new Solution289_gameOfLifeIII();
        int[][] ar = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        two.gameOfLife(ar);
        System.out.println(ar);
    }
}
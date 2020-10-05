package DropBox;

public class Solution289_gameOfLifeII {

    public void gameOfLife(int[][] board) {
        int[][] ori = new int[board.length][board[0].length];
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ori[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = calculateCounts(directions, i, j, ori);
                if (ori[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = 0;
                else if (ori[i][j] == 0 && count == 3)
                    board[i][j] = 1;
            }
        }
    }

    private int calculateCounts(int[][] directions, int row, int column, int[][] ori) {
        int count = 0;
        for (int[] direction : directions) {
            int i = direction[0] + row;
            int j = direction[1] + column;
            if (i >= 0 && i < ori.length && j >= 0 && j < ori[0].length) {
                if (ori[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Solution289_gameOfLifeII two = new Solution289_gameOfLifeII();
        int[][] ar = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        two.gameOfLife(ar);
        System.out.println(ar);
    }
}
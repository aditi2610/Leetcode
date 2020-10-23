package Facebook;

public class Solution79_WordMatch {
    public boolean exist(char[][] board, String word) {
        // base case
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // if we find the first matching character
                if (board[i][j] == word.charAt(0)) {
                    // go ahead and search for the other ones
                    boolean visited[][] = new boolean[board.length][board[0].length];
                    if (backTrack(i, j, board, word, visited, 0))
                        return true;
                }

            }
        }
        return false;
    }

    boolean backTrack(int row, int col, char[][] board, String word, boolean[][] visited, int startIndex) {
        // if we have already iterated all the characters
        // return true;
        System.out.println(startIndex);

        // if row/col <0 or > max or character doesnt match || this node is already
        // visited return false;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(startIndex) || visited[row][col])
            return false;

        if (startIndex == word.length() - 1) {
            System.out.println("matched : " + startIndex);
            return true;
        }
        visited[row][col] = true;
        boolean top = backTrack(row - 1, col, board, word, visited, startIndex + 1);
        boolean bottom = backTrack(row + 1, col, board, word, visited, startIndex + 1);
        boolean left = backTrack(row, col - 1, board, word, visited, startIndex + 1);

        boolean right = backTrack(row, col + 1, board, word, visited, startIndex + 1);

        boolean result = top || bottom || left || right;
        if (result)
            System.out.println(row + ' ' + col + ' ' + startIndex);
        visited[row][col] = false;
        return result;

    }

    public static void main(String[] args) {
        Solution79_WordMatch match = new Solution79_WordMatch();
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        System.out.println(match.exist(board, "ABCB"));
    }

}

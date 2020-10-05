package graphs;

public class Solution547_Friends {
    public int findCircleNum(int[][] M) {
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                M[i][i] = 0;
                count++;
                dfs(M, i);
            }
        }
        return count;
    }

    private void dfs(int[][] m, int row) {
        for (int i = row; i < m.length; i++) {
            if (m[row][i] == 1) {
                m[row][i] = 0;
                // m[i][row] = 0;
                dfs(m, i);
            }

        }
    }

    public static void main(String args[]) {
        Solution547_Friends friends = new Solution547_Friends();
        int[][] nums = { { 1, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 } };
        System.out.println(friends.findCircleNum(nums));
    }
}
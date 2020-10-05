package DropBox;

public class Solution547_findFriends {

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

    private void dfs(int[][] m, int rowNum) {
        for (int i = 0; i < m.length; i++) {
            if (m[rowNum][i] == 1) {
                m[rowNum][i] = 0;
                m[i][rowNum] = 0;
                dfs(m, i);
            }
        }
    }

    public static void main(String[] args) {
        Solution547_findFriends findFriends = new Solution547_findFriends();
        // int[][] graph = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        // int[][] graph = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        int[][] graph = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
        System.out.println(findFriends.findCircleNum(graph));
    }
}
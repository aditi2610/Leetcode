package July10;

public class Solution463_Island {
    
    public int islandPerimeter(int[][] grid) {
        int top = 0, left =0, right =0, bottom =0;
        //count top
        //count left
        // count right
        //count bottom
        for(int i =0; i< grid.length; i++){
            for(int j =0; j< grid[i].length; j++){
                if(grid[i][j]==1){
                    //check top
                    //check left
                    //check right
                    //check bottom
                    if(i==0 || grid[i-1][j]==0)
                        top++;      
                    if(j==0 || grid[i][j-1]==0)
                        left++;
                    if(i == grid.length -1 || grid[i+1][j]==0)
                        bottom++;
                    if(j == grid[i].length -1 || grid[i][j+1]==0)
                        right++;
                }
            }
        }
        return left+right+top+bottom;
    }
    public static void main(String args[]){
        Solution463_Island island = new Solution463_Island();
    //int[][] arr = {{0,1,0,0}, {1,1,1,0} ,{0,1,0,0},{1,1,0,0}};
     //  int[][] arr = {{1,0}};
       int[][] arr = { { 1, 1 }, {1,1} };
       System.out.println(island.islandPerimeter(arr));

    }
}
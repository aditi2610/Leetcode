package Array_my;

public class Solution48_RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length-1;
        int temp =0;
        for(int i =0; i< length; i++){
            for(int j =i; j< length-i;j++){
                //i=0; j=1
                temp = matrix[i][j];
                matrix[i][j]= matrix[length-j][i];
                matrix[length-j][i] = matrix[length-i][length-j];
                matrix[length-i][length-j] = matrix[j][length-i];
                 matrix[j][length-i] = temp;
            }
        }
    }

    public static void main(String args[]){
        Solution48_RotateImage rotate = new Solution48_RotateImage();
        //int[][] matrix = {{1,2, 3,4},{5,6,7,8},{9,0,10,11},{12,13,14,15}};
        int[][] matrix = {{1,2}{3,4}};
        rotate.rotate(matrix);

        for (int i =0; i< matrix.length; i++){
            for(int j= 0; j<matrix.length; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
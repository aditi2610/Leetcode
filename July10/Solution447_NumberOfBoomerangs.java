import java.util.HashMap;
import java.util.Map;

public class Solution447_NumberOfBoomerangs {
   
    public static void main(String args[]){
        Solution447_NumberOfBoomerangs numberBoomerang = new Solution447_NumberOfBoomerangs();
        int[][] points = {{1,0}, {2,0}, {0,0}};
        numberBoomerang.numberOfBoomerangs(points);
    }

    public int numberOfBoomerangs(int[][] points) {
        int totalCount = 0;
        Map<Double,Integer> map;
        for(int i=0; i <= points.length; i++){
            map = new HashMap<>();
         
            for(int j = 0 ; j <points.length; j++ ){
                if (i == j)
                    continue;
                   double distance  = calculateDistance(points[i], points[j]);
                   map.put(distance ,map.getOrDefault(distance, 0) +1);
            }

            for(double tr : map.keySet()){
                totalCount += tr.ge
            }
        }


    }

    private double calculateDistance(int[] is, int[] is2) {
       double sqSum = (is[0]-is2[0])^2 + (is[1] -is2[1])^2;
       return Math.sqrt(sqSum);
    }
}
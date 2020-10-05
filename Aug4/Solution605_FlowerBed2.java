package Aug4;

public class Solution605_FlowerBed2 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int i =0; 
            int count =0;
            if(flowerbed.length ==1){
                if(flowerbed[0]==0 && n<=1){
                   return true;
                }
                    
            }
            while(i< flowerbed.length && count <= n){
                if(flowerbed[i]==0){
                    if((i==0 && flowerbed[i+1]== 0) || (i== flowerbed.length-1 && flowerbed[i-1]==0)){
                        count++;
                        i++;
                    }
                    else if(i >1 && i+1< flowerbed.length- 1 && flowerbed[i-1] ==0 && flowerbed[i+1]==0)
                    {
                        count++;
                        i++;
                    }

                }
                i++;
            }
             
            if(count == n)
                return true;
            else return false;
        }

        public static void main(String args[]){
            Solution605_FlowerBed2 f2= new Solution605_FlowerBed2();
            int[] bed= {0,0,1,0,0};
          if(  f2.canPlaceFlowers(bed, 1))
          System.out.println("Yes");
          else System.out.println("No");

        }
}
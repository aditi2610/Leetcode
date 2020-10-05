package Aug4;

public class Solution605_FlowerBed{

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i =0; 
        int countConsZeros = 0;
        int ans =0;
        while(i< flowerbed.length){
            if(flowerbed[i] ==0){
                  countConsZeros=1;
                  int j =i+1;
                  while(j< flowerbed.length && flowerbed[j]==0){
                        countConsZeros++;
                        j++;
                  }
                   
                    //as soon as we see 1
                   
                        //if count is even 
                        if(countConsZeros %2 ==0 && j== flowerbed.length)
                            ans+= (countConsZeros/2);
                        else if(countConsZeros %2 ==0 && i== 0)
                            ans += countConsZeros / 2;
                        else if(countConsZeros %2 ==0 && flowerbed[i-1]== 1){
                            ans += (countConsZeros/2)-1;
                        }else 
                            ans += countConsZeros / 2;
                        i = j;
                  }
                  else 
                    i++;
                 

                
            }

            if(n== ans)
            return true;
            else return false;
                
        }
         public static void main(String args[]){
        Solution605_FlowerBed flowerBed = new Solution605_FlowerBed();
        int[] fp = {0,0,1,0,1};
        if(flowerBed.canPlaceFlowers(fp,1))
            System.out.println("yes");
        else
            System.out.println("No");
    }
}

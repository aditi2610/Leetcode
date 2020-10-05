
package July10;
public class Solution492_ConstructRectangle{

    public int[] constructRectangle(int area) {
       int[] arr = new int[2];
        double sqroot = Math.sqrt(area);
        if((sqroot *10)%10 == 0){
           arr[0] = (int)sqroot;
           arr[1]= (int)sqroot;
           return arr;
        }
        else{
            for(int i = (int)sqroot; i>=1; i--){
                if(area%i ==0){
                    arr[1] = i;
                     arr[0] = area / i;
                    // if(i > (area/i)){
                    //     arr[0] = i;
                    //     arr[1] = area / i;
                    // }else{
                    //     arr[0] = area / i;
                    //     arr[1] = i;
                    // }
                  
                    break;
                }
            }
            return arr;
        }

        //find the square root of the area
        //if square root is an integer, return
        //else find  ceiling of squareRoot and divide it with area, the first number that divides it completely is the answer.


        //Corner Cases
        //Area is 0 return 0.
        //Area is 3
        //Area is 2. 
        //Area is 5
        }

        public static void main(String args[]){
            Solution492_ConstructRectangle re= new Solution492_ConstructRectangle();
           int[] t= re.constructRectangle(2);
          // System.out.println("Length is:" + t.length);
          for(int k: t){
              System.out.println(" " +k);

              
          }
          
        }
}
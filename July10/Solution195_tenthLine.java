package July10;

public class Solution195_tenthLine {
    

    public static void main(String args[]){
        String file  = new String("1.");
        // String file =  new String("1. Hello \n 2. Aditi \n 3. How are you?\n 4. I am  \n 5.  \n 6.  \n 7. \n 8. \n 9. \n 10."+
        // "\n 11. \n 12. \n 13. \n 14. \n 15. \n 16. \n 17. \n 18. \n 19. \n 20. \n 21.");
        String[] arr =  file.split("\n");
        if(arr.length < 10){
            System.out.println("File is too short. There is no 10th variable");
        }
        else{
            int rt =  arr.length/10;
            for(int i =1; i<= rt ; i++){
                System.out.println(" "+ arr[(i*10) -1]);
            }
        }
        // get the file
        // split linewise
  
        // check if the number of lines is greater than/ equal to  10 , if not, 
        // calculate the total number of Lines and divide by 10. run the counter such
    }


}
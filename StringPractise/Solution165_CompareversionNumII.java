package StringPractise;

import java.util.ArrayList;
import java.util.List;

public class Solution165_CompareversionNumII {
    public int compareVersion(String version1, String version2) {
        List<Integer> num1 = getNumber(version1);
        List<Integer> num2 = getNumber(version2);

        for(int i=0; i< Math.max(num1.size(), num2.size()); i++){
            int temp1 = i< num1.size()? num1.get(i): 0;
            int temp2 = i< num2.size()? num2.get(i):0;
            if (temp1 > temp2) return 1;
            else if(temp2 > temp1)  return -1;
        }
            return 0;

    }

    private List<Integer> getNumber(String version){
        List<Integer> list = new ArrayList<>();
        int current =0;
        int j =0; 
        while(j< version.length()){
            if(version.charAt(j) == '.'){
                
                list.add(Integer.parseInt(version.substring(current, j)));
                current = j+1;
            }
            j++;
        }

       
        list.add(Integer.parseInt(version.substring(current, j)));
      
        return list;
    }

    public static void main(String rags[]){
        Solution165_CompareversionNumII com = new Solution165_CompareversionNumII();
        if (com.compareVersion("01", "1") ==1)
            System.out.println("version1 is gr");
        else if(com.compareVersion("0.1", "1.1") ==-1)
            System.out.println("version 2 is gr");
        else
            System.out.println("Equal");
    }
}
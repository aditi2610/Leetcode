package Aug4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution599_minIndexSumList {

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<StringBuilder> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        StringBuilder temp = new StringBuilder();
        for(int i =0; i<list1.length; i++){
            temp = new StringBuilder(list1[i]);
            for(int j =0; j< list2.length; j++){
                if(temp.toString().equals(list2[j]) && (min >= i+j)){
                    result.add(temp);
                    min = i+j;
                    //result2e[k]= temp;
                    //k++;
                }
            }
        }
       String[] response = new String[result.size()];
        int r=0;

        Iterator iterator = result.iterator();
        while( iterator.hasNext()){
            response[r] = (String)iterator.next().toString();
            r++;
        }
        return response;
    }

    public static void main(String args[]){
        Solution599_minIndexSumList minIndexSumList = new Solution599_minIndexSumList();
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] result = minIndexSumList.findRestaurant(list1, list2);
        for(String s: result){
            System.out.println(s);
        }
    
        
    }
}
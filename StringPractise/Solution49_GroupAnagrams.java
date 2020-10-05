package StringPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result  = new ArrayList<List<String>>();
        Map<String, Integer> uniqueStringMap = new HashMap<String, Integer>();
        List<String> subList;
        int lastIndex = 0;
        for (String stru : strs) {
            
        int index =0;
        // sort the String
        String sortedString  = sortString(stru);
        // if unique String is not empty check if sorted String exists in the Map
        if(uniqueStringMap.containsKey(sortedString)){
            // if it exists, get the index and add to that index
            index = uniqueStringMap.get(sortedString);   
            subList = result.get(index);
            subList.add(stru);
        }
        // if it does not exist, increment the index and add it to the list;
        else{
            uniqueStringMap.put(sortedString, lastIndex);
            subList = new ArrayList<String>();
            subList.add(stru);
            result.add(lastIndex   , subList);
            lastIndex++;
        }  
        }

        return result;
    }

    private String sortString(String str){
        char [] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String args[]){
        Solution49_GroupAnagrams groupAna = new Solution49_GroupAnagrams();
       String[] chae= {"eat", "tea", "tan", "ate", "nat", "bat"};
       System.out.println(groupAna.groupAnagrams(chae).toString());
    }
}
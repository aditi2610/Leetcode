import java.util.*;
import java.io.*;

class ReadFile{

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        String filePath = "Test.txt";
        ReadFile hw = new ReadFile();
        List<List<String>> list = hw.read_file(filePath);
        list.stream().forEach(innerList -> {
            System.out.println(innerList.toString());
        });
    }

    private List<List<String>> read_file(String path){
        List<List<String>> list = new ArrayList<>();
        List<String> cList = new ArrayList<>();
        try{
            BufferedReader reader  = new BufferedReader(new FileReader(path));
            String line;
            while(true){
                line = reader.readLine();
                // If we see an empty line or we reach the end of File
                // add cList to the res and reset the cList
                if(line == null || line.trim().isEmpty() ){
                    if(!cList.isEmpty()){
                        list.add(new ArrayList(cList));
                        cList.clear();
                    }
                    // if this is the end of file, break out of the loop
                    if(line == null)
                        break;
                }
                else{
                    // add current line to the current List
                    cList.add(line);
                }
            }
        }catch(IOException io){
            System.out.println("Error Reading File: "+ io.getMessage());
            return null;
        }
        return list;
    }
}
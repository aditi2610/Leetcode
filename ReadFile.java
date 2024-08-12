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

                if(line == null){
                    if(!cList.isEmpty()){
                        list.add(cList);
                    }
                    break;
                }
                if(line.trim().isEmpty()){
                    if(cList.size() > 0){
                        list.add(new ArrayList(cList));
                        cList.clear();
                    }
                }else{
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
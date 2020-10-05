package DropBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution609_filePath {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String path : paths) {
            String[] ar = path.split(" ");
            String dir = ar[0];
            for (int i = 1; i < ar.length; i++) {
                int startcontent = ar[i].indexOf("(");
                int endContent = ar[i].indexOf(")");
                String content = ar[i].substring(startcontent + 1, endContent);
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(dir + "/" + ar[i].substring(0, startcontent));
                map.put(content, list);
            }
        }

        List<List<String>> list = new ArrayList<List<String>>();

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1)
                list.add(map.get(key));
        }

        return list;

        // return new List<List<String>>();
    }

    public static void main(String[] args) {
        Solution609_filePath file = new Solution609_filePath();
        String[] ar = { "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)" };
        System.out.println(file.findDuplicate(ar));

    }
}
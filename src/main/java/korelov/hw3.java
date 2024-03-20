package korelov;

import java.util.*;

public class hw3 {
    public static void main(String[] args) {
        List<String> list = List.of("sequence",
                "wave",
                "amputate",
                "creation",
                "arrow",
                "camera",
                "attitude",
                "fragment",
                "remark",
                "raid",
                "visible",
                "executrix",
                "train",
                "clay",
                "prince",
                "scrap",
                "entertainment",
                "blackmail",
                "closed",
                "science",
                "pattern",
                "strap",
                "crutch",
                "bang",
                "filter",
                "bible",
                "overcharge",
                "cause",
                "grounds",
                "tree",
                "jump",
                "disgrace",
                "opposed",
                "pitch",
                "linen",
                "rock",
                "permanent",
                "velvet",
                "tooth",
                "scale");

        List<String> stringList = new ArrayList<>(list);
        System.out.println(stringList);
        System.out.println(stringList.size());

        // List<String> collect = stringList.stream().sorted(Comparator.comparingInt(String::length)).toList();

        stringList.sort(Comparator.comparingInt(String::length));
        System.out.println(stringList);
        // System.out.println(collect);

        System.out.println("=======================");
        Map<Character, String> map = new HashMap<>();

        for (String string : stringList) {
            char charAt = string.charAt(0);
            map.put(charAt, string);
        }
//        map.put('a', "Anna");
//        map.put('a', "Maksim");

        //     System.out.println(map.get('a'));
        // System.out.println(map.get('m'));

//        System.out.println(map.keySet());
//        System.out.println(map.values());

//        for (int i = 0; i < stringList.size(); i++) {
//            char charAt = stringList.get(i).charAt(0);   // a  //a
//            String string = stringList.get(i);  //  amputate   // arrow
//
//            if (map.get(charAt) == null) {    //null   // amputate
//                map.put(charAt, string);
//                continue;
//            }
//            if (map.get(charAt).length() < string.length()) {  // amputate.length()   <  arrow
//                map.put(charAt, string);
//            }
//            map.put(charAt, string);
//        }
        System.out.println(map.keySet().size());
        System.out.println(map.keySet());
        System.out.println(map.values().size());
        System.out.println(map.values());
    }

}

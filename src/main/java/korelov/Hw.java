package korelov;

import java.util.ArrayList;
import java.util.List;

public class Hw {
    public static void main(String[] args) {
        List<String> list = List.of("White.",
                "Tan.",
                "Yellow.",
                "Orange.",
                "Red.",
                "Pink.",
                "Purple.",
                "Blue.",
                "White.",
                "Tan.",
                "Yellow.",
                "Orange.",
                "Red.",
                "Pink.",
                "Purple.",
                "Blue."
        );
        List<String> stringList = new ArrayList<>(list);
        String s = "Yellow";
        boolean l = s.contains("l");
        boolean l1 = s.indexOf("m") > -1;

        System.out.println(stringList);
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).contains("l")) {
                String string = stringList.get(i);
                stringList.remove(string);
                i--;
            }
        }
        System.out.println(stringList);
        //  stringList.stream().filter(string -> !string.contains("l")).forEach(System.out::print);
    }
}

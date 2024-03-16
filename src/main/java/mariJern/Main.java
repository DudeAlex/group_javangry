package mariJern;

import java.text.Normalizer;

import static Utils.CustomStringFormat.getUpperCaseString;

public class Main {

    public static String happy = """
                In every life we have some trouble
                But when you worry you make it double
                Don't worry
                Be happy =)""";

    public static String normalizeText(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
    public static void main(String[] args) {



        System.out.println(getUpperCaseString(happy));


    }
}

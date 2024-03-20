package korelov;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hw2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 100; i <= 1_000; i++) {
            list.add(i);
        }
        System.out.println(list);

//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) % 2 == 0) {
//                list.remove(list.get(i--));
//                //list.remove(i);
//            }
//        }
//        System.out.println(list);

        //
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}

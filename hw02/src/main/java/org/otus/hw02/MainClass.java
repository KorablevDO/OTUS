package org.otus.hw02;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        List<Integer> list = new DIYArrayList<>();

        int max = 60;
        Random random = new Random();
        for (int i = 0; i < max; i++) {
            list.add(random.nextInt(10000) + 10);
        }
        System.out.println(list);

        List<Integer> newList = new DIYArrayList<>();
        Collections.addAll(newList, 1, 2, 3, 4, 5);
        System.out.println(newList);
        Collections.copy(list, newList);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 == null ?
                        (o2 == null ? 0 : Integer.MIN_VALUE) :
                        (o2 == null ? Integer.MAX_VALUE : o1.compareTo(o2));
            }
        });
        System.out.println(list);
    }
}

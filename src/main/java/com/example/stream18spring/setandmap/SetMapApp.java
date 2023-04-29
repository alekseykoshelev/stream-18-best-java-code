package com.example.stream18spring.setandmap;

import java.util.*;

public class SetMapApp {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7);
        for (Integer num : nums) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // task 2

        System.out.println("Задача 2");
        List<Integer> nums2 = new ArrayList<>(List.of(20, 1, 0, 1, 12, 2, 3, 4, 4, 5, 12, 5, 6, 7));
        Set<Integer> set2 = new TreeSet<>();
        for (Integer num : nums2) {
            if (num % 2 == 0) {
                set2.add(num);
            }
        }
        System.out.println(set2);

        // task 3
        List<String> strings = List.of("один", "один", "два", "два", "два", "три", "три", "три");
        Set<String> wordSet = new HashSet<>(strings);
        System.out.println(wordSet);

        // task 4
        List<String> strings2 = List.of("один", "один", "два", "два", "два", "три", "три", "три");
        System.out.println("======================");
        a();


    }


    public static void printCountWords(Set<String> words2) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word : words2) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
        }
        System.out.println(map.values());
    }

    private static void task4() {
        List<String> stringList = new ArrayList<>(List.of("qaz", "wsx", "qaz", "qaz", "edc", "wsx"));
//        Map<String, Integer> mapa = new HashMap<>();
//        for (String list : stringList) {
//            if (mapa.containsKey(list)) {
//                mapa.put(list, mapa.get(list) + 1);
//            } else {
//                mapa.put(list, 0);
//            }
//        }
//        System.out.println(mapa);

        Set<String> hashSet = new HashSet<>(stringList);
        for (String set : hashSet) {
            System.out.println(Collections.frequency(stringList, set) - 1);
        }

    }

    private static void a() {
        System.out.println("Задание 4");
        List<String> strings = new ArrayList<>(List.of("один", "один", "два", "два", "два", "два", "три", "три", "три"));
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.size(); i++) {
            int counter = 0;
            for (int i1 = 0; i1 < strings.size(); i1++) {
                if (strings.get(i).equals(strings.get(i1))) {
                    map.put(strings.get(i), counter++);
                }
            }
        }

        for (Map.Entry<String, Integer> values : map.entrySet()) {
            System.out.println(values.getValue());
        }
    }

    private static void be() {
        System.out.println("Задача 4");
        List<String> strings = new ArrayList<>(List.of("один", "один", "два", "два", "два",
                "три", "три", "три", "четыре"));

        Set<String> strings2 = new HashSet<>(strings);
        for (String s : strings2) {
            int i = -1;
            for (String string : strings) {
                if (string.equals(s)) {
                    i++;
                }
            }
            if (i > 0) {
                System.out.print(i + "  ");
            }
        }
    }
}

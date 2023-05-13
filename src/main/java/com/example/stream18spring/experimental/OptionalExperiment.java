package com.example.stream18spring.experimental;

import org.apache.logging.log4j.util.BiConsumer;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class OptionalExperiment {
    public static void main(String[] args) throws Exception {
        Integer value = null;
        var r = Optional.ofNullable(value)
                .map(it -> it * 2)
//                .filter(it -> it % 2 != 0);
                .filter(it -> it % 2 == 0);
        if (r.isPresent()) {
            System.out.println(r.get());
        }
        System.out.println(r.get());
        System.out.println();


        BiConsumer<Integer, Integer> bi = (val1, val2) -> System.out.println(val1 + " " + val2);
        Consumer<Integer> single = (val1) -> System.out.println(val1 + " ");

        var s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        s.filter(val -> {
                    if (val == 7) {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return true;
                })
                .forEach(System.out::println);
    }


}

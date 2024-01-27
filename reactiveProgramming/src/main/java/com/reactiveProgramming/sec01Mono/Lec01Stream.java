package com.reactiveProgramming.sec01Mono;

import java.util.stream.Stream;

public class Lec01Stream {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1,2).map(i ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return i*2;
        });
        integerStream.forEach(System.out::println);
    }




}

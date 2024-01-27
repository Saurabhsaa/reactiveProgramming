package com.reactiveProgramming.sec04Operators;

import reactor.core.publisher.Flux;

public class Practice {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .filter(i -> i > 5)
                .log()
                .take(3)
                .log()
                .next()
                .log()
                .subscribe(System.out::println);
    }
}

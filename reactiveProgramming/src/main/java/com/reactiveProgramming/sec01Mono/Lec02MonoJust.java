package com.reactiveProgramming.sec01Mono;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {
        //mono can store only one data at a time or nothing (0)
        Mono<Integer> mono = Mono.just(1);
        mono.subscribe(i-> System.out.println("Subscribed "+i));
    }

}

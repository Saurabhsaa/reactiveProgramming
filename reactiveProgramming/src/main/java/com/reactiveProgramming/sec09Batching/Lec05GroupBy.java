package com.reactiveProgramming.sec09Batching;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05GroupBy {

    public static void main(String[] args) {
        Flux.range(1,30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i%2)
                .subscribe(gf -> processGroupedFlux(gf,gf.key()));

        Util.sleepThred(60);
    }

    private static void processGroupedFlux(Flux<Integer> flux, Integer key){
        System.out.println("Group flux method called ");
        flux.subscribe(i-> System.out.println("Key : "+key+" Item "+i));
    }
}

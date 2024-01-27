package com.reactiveProgramming.sec04Operators;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07Timeout {
    public static void main(String[] args) {
        getOrderNumber()
                .log()
                .timeout(Duration.ofSeconds(2),fallBack())
                .log()
                .subscribe(Util.subscriber());

        Util.sleepThred(160);
    }

    private static Flux<Integer> getOrderNumber(){
        return Flux.range(0,10)
                .delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallBack(){
        return Flux.range(100,10)
                .delayElements(Duration.ofMillis(200));
    }
}

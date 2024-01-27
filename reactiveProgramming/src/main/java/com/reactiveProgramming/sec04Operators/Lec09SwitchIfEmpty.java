package com.reactiveProgramming.sec04Operators;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {

    //fallback can be used in case of redis case implementations
    public static void main(String[] args) {
        getOrderNumbers().log()
                .filter(item -> item>7)
                .switchIfEmpty(fallBack())
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(0,10);
    }

    private static Flux<Integer> fallBack(){
        return Flux.range(100,10);
    }

}

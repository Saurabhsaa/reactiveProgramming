package com.reactiveProgramming.sec04;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec08DefaultIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers().log()
                .filter(item -> item>8)
                .defaultIfEmpty(100)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(0,10);
    }
}

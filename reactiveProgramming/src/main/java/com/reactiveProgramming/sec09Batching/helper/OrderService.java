package com.reactiveProgramming.sec09Batching.helper;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class OrderService {

    public static Flux<PurchageOrder> orderStream(){
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> new PurchageOrder());
    }

}

package com.reactiveProgramming.sec02.assignment;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class PricePublisher {

    public static Flux<Integer>  getStockPrice(){
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i-> atomicInteger.accumulateAndGet(Util.faker().random().nextInt(-5,5),Integer::sum));
    }

}

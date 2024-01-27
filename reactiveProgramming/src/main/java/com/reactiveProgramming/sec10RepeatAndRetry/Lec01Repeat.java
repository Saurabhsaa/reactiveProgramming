package com.reactiveProgramming.sec10RepeatAndRetry;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec01Repeat {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {

        getIntegers()
//                .repeat(2)
                .repeat(()->atomicInteger.get()<17)
                .subscribe(Util.subscriber());

        Util.sleepThred(60);

    }

    public static Flux<Integer> getIntegers(){
        return Flux.range(1,3)
                .delayElements(Duration.ofMillis(100))
                .doOnSubscribe((i)-> System.out.println("Subscribed "))
                .doOnComplete(()-> System.out.println("Completed .."))
                .map(i -> atomicInteger.getAndIncrement());
    }

}

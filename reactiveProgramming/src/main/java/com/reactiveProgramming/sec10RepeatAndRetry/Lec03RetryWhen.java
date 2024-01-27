package com.reactiveProgramming.sec10RepeatAndRetry;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;

public class Lec03RetryWhen {

    public static void main(String[] args) {

        getIntegers()
                .retryWhen(Retry.fixedDelay(2,Duration.ofSeconds(2)))
                .subscribe(Util.subscriber());

        Util.sleepThred(20);

    }

    public static Flux<Integer> getIntegers(){
        return Flux.range(1,3)
                .delayElements(Duration.ofMillis(100))
                .doOnSubscribe((i)-> System.out.println("Subscribed "))
                .doOnComplete(()-> System.out.println("Completed .."))
                .map(i -> i/Util.faker().random().nextInt(0,1))
                .doOnError(err -> System.out.println("--error"));
    }

}

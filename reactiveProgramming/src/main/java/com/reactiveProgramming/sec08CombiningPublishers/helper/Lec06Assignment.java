package com.reactiveProgramming.sec08CombiningPublishers.helper;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec06Assignment {

    public static void main(String[] args) {

        final int price = 10000;

        Flux.combineLatest(getMonths(),getFactor(),(month,factor)->{
            return (price - (month*100))*factor;
        }).subscribe(Util.subscriber());

        Util.sleepThred(120);
    }

    private static Flux<Long> getMonths(){
        return Flux.interval(Duration.ZERO,Duration.ofSeconds(1));
    }

    private static Flux<Double> getFactor(){
        return Flux.interval(Duration.ofSeconds(3))
                .map(i -> Util.faker().random().nextInt(80,120)/100d);
    }
}

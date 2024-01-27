package com.reactiveProgramming.sec07BackpressureOverFlow;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec01Demo {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 100; i++) {
                fluxSink.next(i);
                System.out.println("Produced : " + i);
            }
            fluxSink.complete();
        }).publishOn(Schedulers.boundedElastic())
                .doOnNext(i-> Util.sleepThredMillSec(10))
                .subscribe(Util.subscriber());

        Util.sleepThred(5);
    }

}

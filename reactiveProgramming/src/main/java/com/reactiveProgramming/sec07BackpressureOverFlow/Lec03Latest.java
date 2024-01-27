package com.reactiveProgramming.sec07BackpressureOverFlow;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03Latest {

    public static void main(String[] args) {
        //75% rules applied here as well
        System.setProperty("reactor.bufferSize.small", "16");
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 400; i++) {
                        fluxSink.next(i);
                        System.out.println(" Produced : "+i);
                        Util.sleepThredMillSec(1);
                    }
                    fluxSink.complete();
                }).onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext((i)-> Util.sleepThredMillSec(10))
                .subscribe(Util.subscriber());

        Util.sleepThred(15);
    }

}

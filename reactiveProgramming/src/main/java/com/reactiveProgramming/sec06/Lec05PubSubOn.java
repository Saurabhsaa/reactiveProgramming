package com.reactiveProgramming.sec06;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec05PubSubOn {

    public static void main(String[] args) {
        Flux<Object> objectFlux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .doOnNext((i)-> printThreadName("on Next"+ " " +i));

        objectFlux.publishOn(Schedulers.parallel())
                .doOnNext(i->printThreadName("doOnNext "+ i))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe((i)->printThreadName("subscribed "+i));

        Util.sleepThred(10);
    }

    public static void printThreadName(String msg){
        System.out.println(msg +" thread name "+ Thread.currentThread().getName());
    }

}

package com.reactiveProgramming.sec06;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03SubscribeOnMultipleItems {

    public static void main(String[] args) {
        Flux<Object> objectFlux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next("1");
                    Util.sleepThred(1);
                })
                .doOnNext((i)->printThreadName("on Next"));


        Runnable runnabler = ()->objectFlux.subscribeOn(Schedulers.boundedElastic())
                                        .subscribe((i)->printThreadName("subscribed 1"));

        //for each consumer there will be a separate thread created and that thread will do all the tasks
        //in synchronous manner
        for (int i = 0; i < 5; i++) {
            new Thread(runnabler).start();
        }

        Util.sleepThred(10);
    }

    public static void printThreadName(String msg){
        System.out.println(msg +" thread name "+ Thread.currentThread().getName());
    }
}

package com.reactiveProgramming.sec06ThreadingAndSchedulars;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOn {

    public static void main(String[] args) {
        Flux<Object>  objectFlux = Flux.create(fluxSink -> {
            printThreadName("create");
            fluxSink.next("1");
        }).subscribeOn(Schedulers.newParallel("near to flux"))
                .doOnNext((i)->printThreadName("on Next"));

        //main thread will start but after subscribeOn new thread will get created
//        objectFlux.doFirst(()-> printThreadName("DoFirst 1"))
//                .subscribeOn(Schedulers.boundedElastic())
//                .doFirst(()-> printThreadName("DoFirst 2"))
//                .subscribe((i)->printThreadName("subscribed 1"));

        Runnable runnabler = ()->objectFlux.doFirst(()-> printThreadName("DoFirst 1"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(()-> printThreadName("DoFirst 2"))
                .subscribe((i)->printThreadName("subscribed 1"));

        for (int i = 0; i < 2; i++) {
            new Thread(runnabler).start();
        }

        Util.sleepThred(5);
    }

    public static void printThreadName(String msg){
        System.out.println(msg +" thread name "+ Thread.currentThread().getName());
    }

}

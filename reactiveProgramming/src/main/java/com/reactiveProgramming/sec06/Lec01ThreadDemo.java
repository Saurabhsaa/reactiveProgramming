package com.reactiveProgramming.sec06;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {

    public static void main(String[] args) {

        Flux<Object> stringFlux = Flux.create(fluxSink -> {
            printThreadName();
            fluxSink.next("1");
        }).doOnNext(i-> printThreadName());

        //all the process will be done by main thread
//        stringFlux.subscribe((i)-> printThreadName());

        Runnable runnable = () -> stringFlux.subscribe((i)-> printThreadName());

        //two separate threads are in action ..
        for(int i=0;i<2;i++){
            new Thread(runnable).start();
        }

        //main thread is waiting here for 2 sec .. so the other threads can be completed
        Util.sleepThred(2);

    }

    public static void printThreadName(){
        System.out.println("Current thread : "+Thread.currentThread().getName());
    }

}

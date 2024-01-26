package com.reactiveProgramming.sec06;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {

    public static void main(String[] args) {
        Flux.range(1,10)
                //based on cpu cores bounded elasic threads will be created
                //.parallel(10) //to create 10 threads
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .doOnNext((i) -> printThreadName("doOnNext "+i))
                .sequential() //parallel returns ParallelFlux to make use of subscribeOn,publishOn we can have sequentinal()
                .subscribe((i)->printThreadName("subscribed "+i));

        Util.sleepThred(12);

    }

    public static void printThreadName(String msg){
        System.out.println(msg +" thread name "+ Thread.currentThread().getName());
    }

}

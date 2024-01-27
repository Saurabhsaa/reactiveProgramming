package com.reactiveProgramming.sec11Sinks;

import com.reactiveProgramming.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Lec03SinkThreadSafety {

    public static void main(String[] args) {

        //handle through which we will push data
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        //handle through which subscriber will receive data
        Flux<Object> flux = sink.asFlux();
        List<Object> res = new ArrayList<>();

        flux.subscribe(res::add);

//        we need to handle the error scenerio to get all emited data else we can skit some data
//        even sink is thread safe
//        for (int i = 0; i < 1000; i++) {
//            final int j = i;
//            CompletableFuture.runAsync(()->sink.tryEmitNext(j));
//        }
        for (int i = 0; i < 1000; i++) {
            final int j = i;
            CompletableFuture.runAsync(()->sink.emitNext(j,(signalType, emitResult) -> true));
        }


        Util.sleepThred(3);
        System.out.println(res.size());

    }

}
